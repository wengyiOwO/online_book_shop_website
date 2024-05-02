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
public class CartService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;
    
    public CartService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public List<Cart> findAll() {
        List bookList = mgr.createNamedQuery("Cart.findAll").getResultList();
        return bookList;
    }
    
    public boolean addCart(Cart cart) {
        mgr.persist(cart);
        return true;
    }

    public Cart findCartByCartID(String cartId) {
        Cart cart = mgr.find(Cart.class, cartId);
        return cart;
    }
    
    public List<Cart> findCartByUserId(Users userId){
        List cartList = mgr.createNamedQuery("Cart.findCartByUserId").setParameter("userId",userId).getResultList();
        return cartList;
    }

    public boolean deleteCart(String cartId) {
        Cart cart = findCartByCartID(cartId);
        if (cart != null) {
            mgr.remove(cart);
            return true;
        }
        return false;
    }
    
    public boolean deleteCartbyUserId(Users userId) {
        List<Cart> cart = findCartByUserId(userId);
        if (cart != null) {
            mgr.remove(cart);
            return true;
        }
        return false;
    }

    

    public boolean updateItem(Cart cart) {
        Cart tempCart = findCartByCartID(cart.getCartId());
        if (tempCart != null) {
            tempCart.setBookId(cart.getBookId());
            return true;
        }
        return false;
    }
}
