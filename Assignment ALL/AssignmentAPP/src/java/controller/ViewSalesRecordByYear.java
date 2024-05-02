package controller;

import model.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ViewSalesRecordByYear extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            OrderHistoryService orderHistoryService = new OrderHistoryService(em);
            List<OrderHistory> orderHistoryList = orderHistoryService.findAll();
            List<OrderHistory> salesList = new ArrayList<OrderHistory>();
            double totalSales = 0;
            String title = "Sales Record of ";
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            String formattedTodayDate = dateFormat.format(currentDate);

            for (OrderHistory orderHistory : orderHistoryList) {
                String formattedOrderDate = dateFormat.format(orderHistory.getOrderId().getOrderDate());
                if (formattedOrderDate.equals(formattedTodayDate)) {
                    salesList.add(orderHistory);
                    totalSales += orderHistory.getQuantity() * orderHistory.getBookId().getPrice();
                }
            }
            title += formattedTodayDate;
            HttpSession session = request.getSession();
            session.setAttribute("title", title);
            session.setAttribute("totalSales", totalSales);
            session.setAttribute("salesList", salesList);
            response.sendRedirect("admin/ViewSalesRecord.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ViewSalesRecordByYear.class.getName()).log(Level.SEVERE, null, ex);
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
