/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author louis
 */
public class PaymentService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;
    
    public PaymentService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public List<Payment> findAll() {
        List payment = mgr.createNamedQuery("Payment.findAll").getResultList();
        return payment;
    }
    public boolean addPayment(Payment payment) {
        mgr.persist(payment);
        return true;
    }
    public Payment findPaymentByPaymentId(String paymentId) {
        Payment payment = mgr.find(Payment.class, paymentId);
        return payment;
    }
}
