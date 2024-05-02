package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class OrderHistoryService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public OrderHistoryService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addOrderHistory(OrderHistory orderHistory) {
        mgr.persist(orderHistory);
        return true;
    }

    public OrderHistory findOrderHistoryById(String id) {
        OrderHistory orderHistory = mgr.find(OrderHistory.class, id);
        return orderHistory;
    }

    public List<OrderHistory> findAll() {
        List orderHistoryList = mgr.createNamedQuery("OrderHistory.findAll").getResultList();
        return orderHistoryList;
    }

//    public boolean updateBook(OrderHistory orderHistory) {
//        OrderHistory tempOrderHistory = findOrderHistoryById(book.getBookId());
//        if (tempBook != null) {
//            tempBook.setBookName(book.getBookName());
//            tempBook.setAuthor(book.getAuthor());
//
//            return true;
//        }
//        return false;
//    }
}
