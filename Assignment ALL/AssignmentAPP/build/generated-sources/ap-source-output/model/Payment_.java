package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Orders;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Double> total;
    public static volatile SingularAttribute<Payment, Orders> orderId;
    public static volatile SingularAttribute<Payment, String> paymentId;
    public static volatile SingularAttribute<Payment, String> paymentMethod;

}