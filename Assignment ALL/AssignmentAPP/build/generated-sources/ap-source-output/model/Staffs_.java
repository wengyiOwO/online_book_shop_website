package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Roles;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Staffs.class)
public class Staffs_ { 

    public static volatile SingularAttribute<Staffs, String> password;
    public static volatile SingularAttribute<Staffs, String> companyEmail;
    public static volatile SingularAttribute<Staffs, Roles> roleId;
    public static volatile SingularAttribute<Staffs, String> staffName;
    public static volatile SingularAttribute<Staffs, String> phoneNum;
    public static volatile SingularAttribute<Staffs, String> staffId;

}