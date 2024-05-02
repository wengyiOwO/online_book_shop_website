package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Staffs;
import model.Users;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile ListAttribute<Roles, Users> usersList;
    public static volatile ListAttribute<Roles, Staffs> staffsList;
    public static volatile SingularAttribute<Roles, String> roleId;
    public static volatile SingularAttribute<Roles, String> roleName;
    public static volatile SingularAttribute<Roles, String> roleDescription;

}