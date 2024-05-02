package controller;

import model.*;
import java.io.*;
import java.util.logging.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

@MultipartConfig

public class UpdateBook extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BooksService bookService = new BooksService(em);
            String bookId = request.getParameter("bookId");
            String bookName = request.getParameter("bookName");
            String bookAuthor = request.getParameter("bookAuthor");
            int bookStock = Integer.parseInt(request.getParameter("bookStock"));
            double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
            String bookCategory = request.getParameter("bookCategory");
            String bookLanguage = request.getParameter("bookLanguage");
            String bookDescription = request.getParameter("bookDescription");
            Books book = new Books(bookId, bookName, bookAuthor,
                    bookStock, bookPrice,
                    bookCategory, bookLanguage, bookDescription);
            InputStream inputStream = null;
            Part filePart = request.getPart("bookImage");
            if (filePart != null && filePart.getSize() > 0) {
                inputStream = filePart.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                byte[] bytes = buffer.toByteArray();
                book.setBookImage(bytes);
            }
            utx.begin();
            boolean success = bookService.updateBook(book);
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            session.setAttribute("book", book);
            response.sendRedirect("admin/UpdateBookConfirm.jsp");
        } catch (Exception ex) {
            Logger.getLogger(UpdateBook.class.getName()).log(Level.SEVERE, null, ex);
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
