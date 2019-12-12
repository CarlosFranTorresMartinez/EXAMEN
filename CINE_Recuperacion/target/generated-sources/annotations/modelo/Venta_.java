package modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Personal;
import modelo.VentaCombos;
import modelo.VentaEntrada;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-12T16:51:58")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, BigDecimal> totavent;
    public static volatile SingularAttribute<Venta, Character> tipvent;
    public static volatile SingularAttribute<Venta, Personal> idper;
    public static volatile SingularAttribute<Venta, Integer> idvent;
    public static volatile SingularAttribute<Venta, Date> fecvent;
    public static volatile ListAttribute<Venta, VentaEntrada> ventaEntradaList;
    public static volatile ListAttribute<Venta, VentaCombos> ventaCombosList;

}