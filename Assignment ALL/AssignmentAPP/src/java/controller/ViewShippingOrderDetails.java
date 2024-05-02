package controller;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ViewShippingOrderDetails extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String shippingId = request.getParameter("shippingId");
            ShippingService shippingService = new ShippingService(em);
            Shipping shipping = shippingService.findShippingById(shippingId);
            String orderId = shipping.getOrderId().getOrderId();
            OrderHistoryService orderHistoryService = new OrderHistoryService(em);
            List<OrderHistory> orderHistoryList = orderHistoryService.findAll();
            List<OrderHistory> orderDetailList = new ArrayList<OrderHistory>();
            for(OrderHistory orderHistory: orderHistoryList){
                if(orderHistory.getOrderId().getOrderId().equals(orderId)){
                    orderDetailList.add(orderHistory);
                }
            }
            HttpSession session = request.getSession();
            session.setAttribute("orderDetailList", orderDetailList);
            session.setAttribute("shipping", shipping);
            response.sendRedirect("staff/ViewShippingOrderDetails.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ViewShippingOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
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
