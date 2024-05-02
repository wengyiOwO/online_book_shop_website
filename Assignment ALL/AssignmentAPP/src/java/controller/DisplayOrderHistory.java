/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import model.OrderHistory;
import model.OrderHistoryService;
import model.Orders;
import model.OrdersService;
import model.Shipping;
import model.ShippingService;
import model.Users;

/**
 *
 * @author louis
 */
public class DisplayOrderHistory extends HttpServlet {

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
        HttpSession session = request.getSession();
        OrderHistoryService orderHistoryService = new OrderHistoryService(em);
        Users user = (Users) session.getAttribute("user");
        OrdersService orderService = new OrdersService(em);
        ShippingService shippingService = new ShippingService(em);
        List<Orders> orders = orderService.getOrdersByUserId(user);
        List<Shipping> shippingList = new ArrayList<Shipping>();
        for (Orders order : orders) {
        Shipping shipping = shippingService.getShippingByOrderId(order);
        shippingList.add(shipping);
        }

        List<List<OrderHistory>> orderHistories = new ArrayList<List<OrderHistory>>();
        for (Orders order : orders) {
            List<OrderHistory> orderHistory = orderService.getOrderHistoryByOrderId(order);
            orderHistories.add(orderHistory);
        }
        session.setAttribute("shippingList", shippingList);
        session.setAttribute("orders", orders);
        session.setAttribute("orderHistories", orderHistories);
        response.sendRedirect("ViewOrderHistory.jsp");
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
