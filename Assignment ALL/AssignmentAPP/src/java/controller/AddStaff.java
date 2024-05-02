package controller;

import model.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

public class AddStaff extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StaffsService staffService = new StaffsService(em);
            List<Staffs> staffList = staffService.findAll();
            String nextId;
            if (!staffList.isEmpty()) {
                Staffs staff = staffList.get(staffList.size() - 1);
                String lastId = staff.getStaffId();
                int idNum = Integer.parseInt(lastId.substring(1));
                nextId = "S" + String.format("%04d", idNum + 1);
            } else {
                nextId = "S1001";
            }
            String newStaffId = nextId;
            String newStaffName = request.getParameter("staffName");
            String newStaffEmail = request.getParameter("staffEmail");
            String newStaffPhoneNum = request.getParameter("staffPhonenumber");
            String newPassword = newStaffId;
            Roles role = new Roles("S");
            Staffs newStaff = new Staffs(newStaffId, newStaffName, 
                    newStaffEmail, newStaffPhoneNum, 
                    newPassword, role);
            utx.begin();
            boolean success = staffService.addStaff(newStaff);
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            session.setAttribute("staff", newStaff);
            response.sendRedirect("admin/ViewStaffDetails.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AddStaff.class.getName()).log(Level.SEVERE, null, ex);
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
