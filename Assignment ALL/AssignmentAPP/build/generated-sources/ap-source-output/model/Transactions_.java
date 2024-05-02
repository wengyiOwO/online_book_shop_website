package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Payment;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-10T19:00:17")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, Payment> paymentId;
    public static volatile SingularAttribute<Transactions, String> transactionId;

}