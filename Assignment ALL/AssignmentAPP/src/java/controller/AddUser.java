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

public class AddUser extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsersService userService = new UsersService(em);
            List<Users> userList = userService.findAll();
            String nextId;
            if (!userList.isEmpty()) {
                Users user = userList.get(userList.size() - 1);
                String lastId = user.getUserId();
                int idNum = Integer.parseInt(lastId.substring(1));
                nextId = "U" + String.format("%04d", idNum + 1);
            } else {
                nextId = "U1001";
            }
            String newUserId = nextId;
            String newUserName = request.getParameter("userName");
            String newUserEmail = request.getParameter("userEmail");
            String newUserPhoneNum = request.getParameter("userPhonenumber");
            String newPassword = newUserId;
            Roles role = new Roles("U");
//            Users newUser = new Users(newUserId, newUserName, 
//                    newUserEmail, newUserPhoneNum, 
//                    newPassword, role);

            utx.begin();
            //boolean success = userService.addUser(newUser);
            utx.commit();
            List<Users> newUserList = userService.findAll();
            HttpSession session = request.getSession();
            //session.setAttribute("success", success);
            session.setAttribute("userList", newUserList);
            session.setAttribute("userId", newUserId);
            response.sendRedirect("admin/ViewUserDetails.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
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
