package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Books;
import model.OrderHistory;
import model.Payment;
import model.Shipping;
import model.Users;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile ListAttribute<Orders, Shipping> shippingList;
    public static volatile ListAttribute<Orders, OrderHistory> orderHistoryList;
    public static volatile SingularAttribute<Orders, String> orderId;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Users> userId;
    public static volatile ListAttribute<Orders, Books> booksList;
    public static volatile ListAttribute<Orders, Payment> paymentList;

}