package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class OrdersService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public OrdersService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addOrder(Orders order) {
        mgr.persist(order);
        return true;
    }

    public Orders findOrderByOrderID(String id) {
        Orders order = mgr.find(Orders.class, id);
        return order;
    }

    public boolean deleteOrder(String id) {
        Orders order = findOrderByOrderID(id);
        if (order != null) {
            mgr.remove(order);
            return true;
        }
        return false;
    }

    public List<Orders> findAll() {
        List orderList = mgr.createNamedQuery("Orders.findAll").getResultList();
        return orderList;
    }

    public List<Orders> findSalesRecord() {
        List orderList = mgr.createNamedQuery("Orders.findSalesRecord").getResultList();
        return orderList;
    }

    public List<Orders> getOrdersByUserId(Users userId) {
        TypedQuery<Orders> query = mgr.createNamedQuery("Orders.findByUserId", Orders.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<OrderHistory> getOrderHistoryByOrderId(Orders orderId) {
        TypedQuery<OrderHistory> query = mgr.createNamedQuery("OrderHistory.findOrderHistoryByOrderId", OrderHistory.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
//    public boolean updateOrder(Orders order) {
//        Orders tempOrder = findOrderById(order.getOrderId());
//        if (tempOrder != null) {
//            tempOrder.setStatus(order.getStatus());
//            return true;
//        }
//        return false;
//    }
}
