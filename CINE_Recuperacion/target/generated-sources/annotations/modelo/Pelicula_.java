package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.GeneroPelicula;
import modelo.VentaEntrada;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-12T16:51:58")
@StaticMetamodel(Pelicula.class)
public class Pelicula_ { 

    public static volatile SingularAttribute<Pelicula, Date> fechestreno;
    public static volatile SingularAttribute<Pelicula, GeneroPelicula> idgen;
    public static volatile SingularAttribute<Pelicula, Date> fechtermino;
    public static volatile SingularAttribute<Pelicula, Integer> salapel;
    public static volatile ListAttribute<Pelicula, VentaEntrada> ventaEntradaList;
    public static volatile SingularAttribute<Pelicula, Integer> idpel;
    public static volatile SingularAttribute<Pelicula, String> nompel;

}