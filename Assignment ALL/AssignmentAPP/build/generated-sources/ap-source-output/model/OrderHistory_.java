package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Books;
import model.Orders;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(OrderHistory.class)
public class OrderHistory_ { 

    public static volatile SingularAttribute<OrderHistory, String> bookOrderId;
    public static volatile SingularAttribute<OrderHistory, Integer> quantity;
    public static volatile SingularAttribute<OrderHistory, Orders> orderId;
    public static volatile SingularAttribute<OrderHistory, Books> bookId;

}