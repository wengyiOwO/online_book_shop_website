/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yongy
 */
@Entity
@Table(name = "ORDER_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHistory.findAll", query = "SELECT o FROM OrderHistory o"),
    @NamedQuery(name = "OrderHistory.findByBookOrderId", query = "SELECT o FROM OrderHistory o WHERE o.bookOrderId = :bookOrderId"),
    @NamedQuery(name = "OrderHistory.findOrderHistoryByOrderId", query = "SELECT oh FROM OrderHistory oh WHERE oh.orderId = :orderId"),
    @NamedQuery(name = "OrderHistory.findOrderHistoryByUserId", query = "SELECT oh FROM OrderHistory oh WHERE oh.orderId.userId = :userId"),
    @NamedQuery(name = "OrderHistory.findByQuantity", query = "SELECT o FROM OrderHistory o WHERE o.quantity = :quantity")})
public class OrderHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "BOOK_ORDER_ID")
    private String bookOrderId;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
    @ManyToOne
    private Books bookId;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne
    private Orders orderId;

    public OrderHistory() {
    }

    public OrderHistory(String bookOrderId) {
        this.bookOrderId = bookOrderId;
    }

    public String getBookOrderId() {
        return bookOrderId;
    }

    public void setBookOrderId(String bookOrderId) {
        this.bookOrderId = bookOrderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Books getBookId() {
        return bookId;
    }

    public void setBookId(Books bookId) {
        this.bookId = bookId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookOrderId != null ? bookOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHistory)) {
            return false;
        }
        OrderHistory other = (OrderHistory) object;
        if ((this.bookOrderId == null && other.bookOrderId != null) || (this.bookOrderId != null && !this.bookOrderId.equals(other.bookOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrderHistory[ bookOrderId=" + bookOrderId + " ]";
    }
    
}
