package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Orders;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Shipping.class)
public class Shipping_ { 

    public static volatile SingularAttribute<Shipping, String> shippingId;
    public static volatile SingularAttribute<Shipping, String> address;
    public static volatile SingularAttribute<Shipping, Orders> orderId;
    public static volatile SingularAttribute<Shipping, String> status;

}