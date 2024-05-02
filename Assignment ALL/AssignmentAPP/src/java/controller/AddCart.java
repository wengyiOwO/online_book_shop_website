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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class AddCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

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
        try {

            HttpSession session = request.getSession();
            CartService cartService = new CartService(em);
            String bookId = request.getParameter("bookId");
            String nextId;
            Users user = (Users) session.getAttribute("user");

            int quantity = Integer.parseInt(request.getParameter("quantity"));
            BooksService bookService = new BooksService(em);
            Books books = bookService.findBookByBookID(bookId);
//            try {
//
//            } catch (NumberFormatException e) {
//
//                session.setAttribute("errorMessage", "The amount inserted is not a number");
//                response.sendRedirect("ProductDetails.jsp");
//            }
            try {
                Query query = em.createNamedQuery("Cart.findCartByUserIdAndBookId");
                query.setParameter("userId", user);
                query.setParameter("bookId", books);
                query.getSingleResult();

                String dupeItem = "There is duplicate item in the cart";
                session.setAttribute("errorMessage", dupeItem);

                response.sendRedirect("ProductDetails.jsp");
            } catch (NoResultException ex) {
                if (quantity <= books.getStocks()) {
                    if (quantity < 0) {

                        session.setAttribute("errorMessage", "The amount inserted cannot be Negative");
                        response.sendRedirect("ProductDetails.jsp");
                    } else {
                        List<Cart> cartList = cartService.findAll();

                        if (!cartList.isEmpty()) {
                            Cart cart = cartList.get(cartList.size() - 1);
                            String lastId = cart.getCartId();
                            int idNum = Integer.parseInt(lastId.substring(1));
                            nextId = "C" + String.format("%04d", idNum + 1);
                        } else {
                            nextId = "C1001";
                        }

                        Cart cart = new Cart(nextId, books, user, quantity);
                        utx.begin();
                        boolean sucess = cartService.addCart(cart);
                        boolean deleteBookStockAfterAddCart = bookService.deleteBookStock(books, quantity, session);
                        em.merge(books);
                        utx.commit();

                        session.setAttribute("sucess", sucess);
                        response.sendRedirect("ProductDetails.jsp");
                    }
                } else {

                    session.setAttribute("errorMessage", "The amount inserted has exceed the amount in the cart");
                    response.sendRedirect("ProductDetails.jsp");
                }
            } 

        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.print(ex);
            System.out.println(ex);
        }

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
