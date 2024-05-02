/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yongy
 */
@Entity
@Table(name = "BOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByBookId", query = "SELECT b FROM Books b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Books.findByBookName", query = "SELECT b FROM Books b WHERE b.bookName = :bookName"),
    @NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author"),
    @NamedQuery(name = "Books.findByStocks", query = "SELECT b FROM Books b WHERE b.stocks = :stocks"),
    @NamedQuery(name = "Books.findByPrice", query = "SELECT b FROM Books b WHERE b.price = :price"),
    @NamedQuery(name = "Books.findByCategory", query = "SELECT b FROM Books b WHERE b.category = :category"),
    @NamedQuery(name = "Books.findByLanguages", query = "SELECT b FROM Books b WHERE b.languages = :languages"),
    @NamedQuery(name = "Books.searchByBookName", query = "SELECT b FROM Books b WHERE b.bookName LIKE :bookName"),
    @NamedQuery(name = "Books.findByDescription", query = "SELECT b FROM Books b WHERE b.description = :description")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "BOOK_ID")
    private String bookId;
    @Lob
    @Column(name = "BOOK_IMAGE")
    private byte[] bookImage;
    @Size(max = 1000)
    @Column(name = "BOOK_NAME")
    private String bookName;
    @Size(max = 50)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "STOCKS")
    private Integer stocks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "LANGUAGES")
    private String languages;
    @Size(max = 5000)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "bookId")
    private List<OrderHistory> orderHistoryList;
    @OneToMany(mappedBy = "bookId")
    private List<Cart> cartList;

    public Books() {
    }

    public Books(String bookId) {
        this.bookId = bookId;
    }

    public Books(String bookId, String bookName, String author, Integer stocks, Double price, String category, String languages, String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.stocks = stocks;
        this.price = price;
        this.category = category;
        this.languages = languages;
        this.description = description;
    }
    
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<OrderHistory> getOrderHistoryList() {
        return orderHistoryList;
    }

    public void setOrderHistoryList(List<OrderHistory> orderHistoryList) {
        this.orderHistoryList = orderHistoryList;
    }

    @XmlTransient
    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Books[ bookId=" + bookId + " ]";
    }
    
}
