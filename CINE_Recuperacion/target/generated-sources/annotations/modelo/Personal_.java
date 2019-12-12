package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-12T16:51:58")
@StaticMetamodel(Personal.class)
public class Personal_ { 

    public static volatile SingularAttribute<Personal, Integer> idper;
    public static volatile SingularAttribute<Personal, String> nomper;
    public static volatile SingularAttribute<Personal, Integer> telper;
    public static volatile ListAttribute<Personal, Venta> ventaList;
    public static volatile SingularAttribute<Personal, String> apeper;
    public static volatile SingularAttribute<Personal, Integer> dniper;
    public static volatile SingularAttribute<Personal, String> tipper;

}