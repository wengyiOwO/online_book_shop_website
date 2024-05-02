package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cart;
import model.Orders;
import model.Roles;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Roles> roleId;
    public static volatile SingularAttribute<Users, String> userEmail;
    public static volatile SingularAttribute<Users, String> phoneNum;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile SingularAttribute<Users, String> userId;
    public static volatile ListAttribute<Users, Orders> ordersList;
    public static volatile ListAttribute<Users, Cart> cartList;

}