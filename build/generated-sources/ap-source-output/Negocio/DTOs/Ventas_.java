package Negocio.DTOs;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-04T22:24:32", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Float> total;
    public static volatile SingularAttribute<Ventas, Float> descuento;
    public static volatile SingularAttribute<Ventas, String> folio;
    public static volatile SingularAttribute<Ventas, Integer> ventaid;
    public static volatile SingularAttribute<Ventas, Date> fecha_venta;
    public static volatile SingularAttribute<Ventas, Integer> usuarioid;
    public static volatile SingularAttribute<Ventas, String> nombre_cliente;

}