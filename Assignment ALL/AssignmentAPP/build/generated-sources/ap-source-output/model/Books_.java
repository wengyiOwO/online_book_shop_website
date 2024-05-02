package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cart;
import model.OrderHistory;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Books.class)
public class Books_ { 

    public static volatile ListAttribute<Books, OrderHistory> orderHistoryList;
    public static volatile SingularAttribute<Books, byte[]> bookImage;
    public static volatile SingularAttribute<Books, String> languages;
    public static volatile SingularAttribute<Books, String> author;
    public static volatile SingularAttribute<Books, Double> price;
    public static volatile SingularAttribute<Books, String> description;
    public static volatile SingularAttribute<Books, String> category;
    public static volatile SingularAttribute<Books, String> bookName;
    public static volatile SingularAttribute<Books, Integer> stocks;
    public static volatile ListAttribute<Books, Cart> cartList;
    public static volatile SingularAttribute<Books, String> bookId;

}