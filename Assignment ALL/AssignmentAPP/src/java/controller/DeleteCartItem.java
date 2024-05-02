
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Books;
import model.BooksService;
import model.Cart;
import model.CartService;
import model.Users;

/**
 *
 * @author louis
 */
public class DeleteCartItem extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try {
            HttpSession session = request.getSession();
            String getString = request.getQueryString();
            String cartId = getString.split("=")[1];
            CartService cartService = new CartService(em);
            BooksService bookService = new BooksService(em);
            Cart findCart = cartService.findCartByCartID(cartId);
            Books books = bookService.findBookByBookID(findCart.getBookId().getBookId());
            int quan = findCart.getQuantity();
            utx.begin();
            boolean addBookStockAfterRemove = bookService.addBookStock(books,quan);
            boolean successDeleteCart = cartService.deleteCart(cartId);
            utx.commit();
            
            
            Users user = (Users) session.getAttribute("user");
            List<Cart> cartList = (List<Cart>)cartService.findCartByUserId(user);
            session.setAttribute("successDeleteCart",successDeleteCart);
            session.setAttribute("cartList",cartList);
            response.sendRedirect("AddCart.jsp");

        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.print(ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
