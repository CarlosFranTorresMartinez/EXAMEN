package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ComboDetalle;
import modelo.VentaCombos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-12T16:51:58")
@StaticMetamodel(Combo.class)
public class Combo_ { 

    public static volatile SingularAttribute<Combo, Integer> idcom;
    public static volatile ListAttribute<Combo, ComboDetalle> comboDetalleList;
    public static volatile SingularAttribute<Combo, String> nomcom;
    public static volatile SingularAttribute<Combo, Double> precom;
    public static volatile ListAttribute<Combo, VentaCombos> ventaCombosList;

}