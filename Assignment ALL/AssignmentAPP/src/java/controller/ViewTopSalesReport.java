/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Books;
import model.BooksService;
import model.OrderHistory;
import model.OrderHistoryService;

/**
 *
 * @author yongy
 */
public class ViewTopSalesReport extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BooksService bookService = new BooksService(em);
            List<Books> bookList = bookService.findAll();
            Map<String, Integer> bookSales = new HashMap<>();
            for (Books book : bookList) {
                bookSales.put(book.getBookId(), 0);
            }
            OrderHistoryService orderHistoryService = new OrderHistoryService(em);
            List<OrderHistory> orderHistoryList = orderHistoryService.findAll();
            for (OrderHistory orderHistory : orderHistoryList) {
                int sales = bookSales.get(orderHistory.getBookId().getBookId());
                sales += orderHistory.getQuantity();
                bookSales.put(orderHistory.getBookId().getBookId(), sales);
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(bookSales.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            List<Map.Entry<String, Integer>> top5 = list.subList(0, 5);
            HttpSession session = request.getSession();
            session.setAttribute("top5", top5);
            session.setAttribute("bookList", bookList);
            response.sendRedirect("admin/ViewTopSalesReport.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ViewTopSalesReport.class.getName()).log(Level.SEVERE, null, ex);
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
