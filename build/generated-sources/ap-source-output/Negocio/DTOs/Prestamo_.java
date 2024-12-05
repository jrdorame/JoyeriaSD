package Negocio.DTOs;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-04T22:24:32", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Character> estado;
    public static volatile SingularAttribute<Prestamo, Date> fechaLiquidacion;
    public static volatile SingularAttribute<Prestamo, Integer> idUsuario;
    public static volatile SingularAttribute<Prestamo, Integer> idVendedor;
    public static volatile SingularAttribute<Prestamo, String> folio;
    public static volatile SingularAttribute<Prestamo, Date> fechaEntrega;
    public static volatile SingularAttribute<Prestamo, Float> comision;
    public static volatile SingularAttribute<Prestamo, Integer> idPrestamo;
    public static volatile SingularAttribute<Prestamo, Float> totalGeneral;

}