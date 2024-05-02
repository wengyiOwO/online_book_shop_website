/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import model.Roles;
import model.Users;
import model.UsersService;


public class Register extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String userName = request.getParameter("name");
        String userEmail = request.getParameter("email");
        String pNumber = request.getParameter("pNumber");
        String userPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String nextId;

        HttpSession session = request.getSession();

        Users newUser = new Users();
        UsersService newUserService = new UsersService(em);
        Roles roles = new Roles("U");
        newUser.setRoleId(roles);
     

        if (userName.isEmpty()) {
            session.setAttribute("nameError", "Username Length be between 5 to 50 words");
            response.sendRedirect("Register.jsp");
            return;
        } else if ((userName.length() < 5 || userName.length() > 50) || userName.isEmpty()) {
            session.setAttribute("nameError", "Username Length be between 5 to 50 words");
            response.sendRedirect("Register.jsp");
            return;
        } else {
            newUser.setUserName(userName);
        }

        if (!userEmail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            session.setAttribute("emailError", "Invalid email format");
            response.sendRedirect("Register.jsp");
            return;
        } else {
            try {
                Query query = em.createNamedQuery("Users.findByUserEmail");
                query.setParameter("userEmail", userEmail);
                Users existEmail = (Users) query.getSingleResult();

                session.setAttribute("emailError", "Email already exist");
                response.sendRedirect("Register.jsp");
                return;
            } catch (NoResultException e) {
                newUser.setUserEmail(userEmail);
            }
        }

        if (pNumber.isEmpty()) {
            session.setAttribute("numError", "Phone Number Cannot Be Empty!");
            response.sendRedirect("Register.jsp");
            return;
        } else if (!pNumber.matches("^01\\d-\\d{7}$")) {
            session.setAttribute("numError", "Invalid Phone Number Format");
            response.sendRedirect("Register.jsp");
            return;
        } else {
            newUser.setPhoneNum(pNumber);
        }

        if (userPassword.isEmpty()) {
            session.setAttribute("passwdError", "Password Cannot Be Empty!");
            response.sendRedirect("Register.jsp");
            return;
        } else if (userPassword.length() < 5 || userPassword.length() > 20) {
            session.setAttribute("passwdError", "Password Length must be between 5 to 20 characters");
            response.sendRedirect("Register.jsp");
            return;
        }

        if (confirmPassword.isEmpty()) {
            session.setAttribute("conPasswdError", "Confirm Password Cannot be Empty!");
            response.sendRedirect("Register.jsp");
            return;
        } else if (!userPassword.equals(confirmPassword)) {
            session.setAttribute("conPasswdError", "Password does not Match!");
            response.sendRedirect("Register.jsp");
            return;
        } else {
            newUser.setPassword(confirmPassword);
        }

        List<Users> userList = newUserService.findAll();
        // Generate a new ID for the user
        if (!userList.isEmpty()) {
            Users users = userList.get(userList.size() - 1);
            String maxId = users.getUserId();
            int idNum = Integer.parseInt(maxId.substring(1));
            nextId = "U" + String.format("%04d", idNum+1);
            newUser.setUserId(nextId);
        } else {
            nextId = "U1001";
        }

        
        try {
            utx.begin();
            boolean success = newUserService.addUser(newUser);
            utx.commit();
            response.sendRedirect("TYRegister.jsp");

        } catch (Exception e) {
            session.setAttribute("error", "Error");

        }

    }

//    private int getNextUserIdFromSequence() throws SQLException {
//        int rowNum = 0;
//
//        // Create a connection to the database
//        Connection connection = DriverManager.getConnection(url, username, datapassword);
//
//        // Query the database to get the next value of the sequence
//        PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM USERS");
//        ResultSet rs = stmt.executeQuery();
//        if (rs.next()) {
//            rowNum = rs.getInt(1);
//        }
//        return rowNum;
//    }
//    private void insertUserIntoDatabase(UserDomain user) throws SQLException {
//        // Create a connection to the database
//        Connection connection = DriverManager.getConnection(url,username,datapassword);
//        
//        // Insert the user into the database
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (USER_ID, USER_NAME, USER_EMAIL, PHONE_NUMBER, PASSWORD) VALUES (?, ?, ?, ?, ?)");
//        preparedStatement.setString(1, user.getUserID());
//        preparedStatement.setString(2, user.getUserName());
//        preparedStatement.setString(3, user.getUserEmail());
//        preparedStatement.setString(4, user.getUserPNumber());
//        preparedStatement.setString(5, user.getPassword());
//        preparedStatement.executeUpdate();
//        
//        // Close the database resources
//        preparedStatement.close();
//        connection.close();
//    }
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
