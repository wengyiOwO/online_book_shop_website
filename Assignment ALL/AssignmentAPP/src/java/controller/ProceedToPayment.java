/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.CartService;
import model.Users;

/**
 *
 * @author louis
 */
public class ProceedToPayment extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            String address = request.getParameter("address1");
            String state = request.getParameter("state");
            String postCode = request.getParameter("postCode");
            
            String fullAddress = address+","+state+","+postCode;
            CartService cartService = new CartService(em);
            List<Cart> cartList = (List<Cart>)cartService.findCartByUserId(user);
            session.setAttribute("cartList", cartList);
            session.setAttribute("userInfo", user);
            session.setAttribute("fullAddress", fullAddress);
            response.sendRedirect("PaymentDetails.jsp");
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
