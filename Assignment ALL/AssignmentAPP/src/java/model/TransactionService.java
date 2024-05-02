package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class TransactionService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public TransactionService(EntityManager mgr) {
        this.mgr = mgr;
    }
    
    public boolean addTransaction(Transactions transaction) {
        mgr.persist(transaction);
        return true;
    }

    public Transactions findTransactionById(String id) {
        Transactions transaction = mgr.find(Transactions.class, id);
        return transaction;
    }

    public boolean deleteBook(String id) {
        Transactions transaction = findTransactionById(id);
        if (transaction != null) {
            mgr.remove(transaction);
            return true;
        }
        return false;
    }

    public List<Transactions> findAll() {
        List transactionList = mgr.createNamedQuery("Transactions.findAll").getResultList();
        return transactionList;
    }
//echo "TINGWOSHUOXIEXIENIYINWEIYOUNIWENNUANLESIJI";
//    public boolean updateCart(Cart cart) {
//        Cart tempcart = findCartById(cart.getOrderId());
//        if (tempOrder != null) {
//            tempOrder.setStatus(order.getStatus());
//            return true;
//        }
//        return false;
//    }
}
