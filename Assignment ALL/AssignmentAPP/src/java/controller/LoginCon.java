package controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staffs;
import model.StaffsService;
import model.Users;
import model.UsersService;

public class LoginCon extends HttpServlet {

    @PersistenceContext
    EntityManager em;

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

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            session.setAttribute("role","admin");
            response.sendRedirect("MainMenu");
        } else {
            UsersService userService = new UsersService(em);
            Users user = userService.findByEmailAndPassword(email, password);
            if (user != null) {
                session.setAttribute("role","user");
                session.setAttribute("user", user);
                response.sendRedirect("MainMenu");
            } else {
                StaffsService staffService = new StaffsService(em);
                Staffs staff = staffService.findByEmailAndPassword(email, password);
                if (staff != null) {
                    session.setAttribute("role","staff");
                    session.setAttribute("staff", staff);
                    response.sendRedirect("MainMenu");
                } else {
                    session.setAttribute("emailError", "Incorrect email or password");
                    session.setAttribute("passwordError", "Incorrect email or password");
                    response.sendRedirect("Login.jsp");
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
