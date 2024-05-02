package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.http.HttpSession;

public class BooksService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public BooksService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addBook(Books book) {
        mgr.persist(book);
        return true;
    }

    public Books findBookByBookID(String id) {
        Books book = mgr.find(Books.class, id);
        return book;
    }

    public boolean deleteBook(String id) {
        Books book = findBookByBookID(id);
        if (book != null) {
            mgr.remove(book);
            return true;
        }
        return false;
    }

    public List<Books> findAll() {
        List bookList = mgr.createNamedQuery("Books.findAll").getResultList();
        return bookList;
    }

    public boolean updateBook(Books book) {
        Books tempBook = findBookByBookID(book.getBookId());
        if (tempBook != null) {
            tempBook.setBookName(book.getBookName());
            tempBook.setBookImage(book.getBookImage());
            tempBook.setAuthor(book.getAuthor());
            tempBook.setStocks(book.getStocks());
            tempBook.setPrice(book.getPrice());
            tempBook.setCategory(book.getCategory());
            tempBook.setLanguages(book.getLanguages());
            tempBook.setDescription(book.getDescription());
            return true;
        }
        return false;
    }
    
    public boolean deleteBookStock(Books books, int quan, HttpSession session) {
        if (books != null) {
            books.setStocks(books.getStocks() - quan);
            session.setAttribute("books", books);
            return true;
        }
        return false;
    }

    public boolean addBookStock(Books books, int quan) {
        Books tempBooks = findBookByBookID(books.getBookId());
        if (tempBooks != null) {
            tempBooks.setStocks(books.getStocks() + quan);
            return true;
        }
        return false;
    }

    public List<Books> findBookByCategory(String category) {
        // Create and execute the named query
        TypedQuery<Books> query = mgr.createNamedQuery("Books.findByCategory", Books.class);
        query.setParameter("category", category);
        List<Books> books = query.getResultList();

        return books;
    }

    public List<Books> getFirstThreeBooks() {
        List<Books> threeBooks = mgr.createNamedQuery("Books.findAll", Books.class).setMaxResults(3).getResultList();
        return threeBooks;
    }

    public Books getFirstBook() {
        Books firstBooks = mgr.createNamedQuery("Books.findAll", Books.class).setMaxResults(1).getSingleResult();
        return firstBooks;
    }
    public List<Books> searchByBookName(String name) {
        // Create and execute the named query
        TypedQuery<Books> query = mgr.createNamedQuery("Books.searchByBookName", Books.class);
        query.setParameter("bookName", "%" + name + "%");
        List<Books> books = query.getResultList();

        return books;
    }
}
