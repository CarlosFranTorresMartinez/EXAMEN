package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Combo;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-12T16:51:58")
@StaticMetamodel(ComboDetalle.class)
public class ComboDetalle_ { 

    public static volatile SingularAttribute<ComboDetalle, Combo> idcom;
    public static volatile SingularAttribute<ComboDetalle, Integer> idcomdet;
    public static volatile SingularAttribute<ComboDetalle, Productos> idpro;
    public static volatile SingularAttribute<ComboDetalle, Integer> cantpro;

}