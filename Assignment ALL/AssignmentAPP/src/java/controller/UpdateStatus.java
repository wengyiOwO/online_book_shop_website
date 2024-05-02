package controller;

import model.*;
import java.io.*;
import java.util.logging.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

public class UpdateStatus extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ShippingService shippingService = new ShippingService(em);
            String shippingId = request.getParameter("shippingId");
            String button = request.getParameter("button");
            Shipping shipping = shippingService.findShippingById(shippingId);
            if (button.equals("Packaging")) {
                shipping.setStatus("Packaging");
            } else if (button.equals("Shipping")) {
                shipping.setStatus("Shipping");
            } else {
                shipping.setStatus("Delivered");
            }
            utx.begin();
            boolean success = shippingService.updateShipping(shipping);
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("shippingId", shipping.getShippingId());
            session.setAttribute("shipping", shipping);
            session.setAttribute("success", success);
            response.sendRedirect("staff/ViewShippingOrderDetails.jsp");
        } catch (Exception ex) {
            Logger.getLogger(UpdateStatus.class.getName()).log(Level.SEVERE, null, ex);
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
