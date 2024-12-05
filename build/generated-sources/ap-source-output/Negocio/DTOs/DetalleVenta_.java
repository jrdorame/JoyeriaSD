package Negocio.DTOs;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-04T22:24:32", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile SingularAttribute<DetalleVenta, Float> subtotal;
    public static volatile SingularAttribute<DetalleVenta, Integer> DetalleVentaId;
    public static volatile SingularAttribute<DetalleVenta, Integer> IdProducto;
    public static volatile SingularAttribute<DetalleVenta, Integer> ventaId;
    public static volatile SingularAttribute<DetalleVenta, Integer> cantidad;

}