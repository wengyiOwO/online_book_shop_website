package controller;

import model.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

@MultipartConfig

public class AddBook extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BooksService bookService = new BooksService(em);
            List<Books> bookList = bookService.findAll();
            String nextId;
            if (!bookList.isEmpty()) {
                Books book = bookList.get(bookList.size() - 1);
                String lastId = book.getBookId();
                int idNum = Integer.parseInt(lastId.substring(1));
                nextId = "B" + String.format("%04d", idNum + 1);
            } else {
                nextId = "B1001";
            }
            String newBookId = nextId;
            String newBookName = request.getParameter("bookName");
            String newBookAuthor = request.getParameter("bookAuthor");
            int newBookStock = Integer.parseInt(request.getParameter("bookStock"));
            double newBookPrice = Double.parseDouble(request.getParameter("bookPrice"));
            String newBookCategory = request.getParameter("bookCategory");
            String newBookLanguage = request.getParameter("bookLanguage");
            String newBookDescription = request.getParameter("bookDescription");
            Books newBook = new Books(newBookId, newBookName.toUpperCase(), newBookAuthor,
                    newBookStock, newBookPrice,
                    newBookCategory, newBookLanguage, newBookDescription);
            
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
                newBook.setBookImage(bytes);
            }
            utx.begin();
            boolean success = bookService.addBook(newBook);
            utx.commit();
            List<Books> newBookList = bookService.findAll();
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            session.setAttribute("book", newBook);
            response.sendRedirect("staff/ViewBookDetails.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
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
