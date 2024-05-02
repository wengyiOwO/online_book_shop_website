package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class ShippingService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public ShippingService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addShipping(Shipping shipping) {
        mgr.persist(shipping);
        return true;
    }

    public Shipping findShippingById(String id) {
        Shipping shipping = mgr.find(Shipping.class, id);
        return shipping;
    }

    public boolean deleteShipping(String id) {
        Shipping shipping = findShippingById(id);
        if (shipping != null) {
            mgr.remove(shipping);
            return true;
        }
        return false;
    }

    public List<Shipping> findAll() {
        List shippingList = mgr.createNamedQuery("Shipping.findAll").getResultList();
        return shippingList;
    }

    public boolean updateShipping(Shipping shipping) {
        Shipping tempShipping = findShippingById(shipping.getShippingId());
        if (tempShipping != null) {
            tempShipping.setStatus(shipping.getStatus());
            return true;
        }
        return false;
    }
    
    public Shipping getShippingByOrderId(Orders orderId) {
        TypedQuery<Shipping> query = mgr.createNamedQuery("Shipping.findByOrderId", Shipping.class);
        query.setParameter("orderId", orderId);
        return query.getSingleResult();
    }
}
