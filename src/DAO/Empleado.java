
package DAO;

import Interface.IEmpleadoRepositorio;
import Negocio.DTOs.EmpleadoDTO;
import Repositorio.RepositorioBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;



/**
 *
 * @author Dórame
 */
public class Empleado extends RepositorioBase<EmpleadoDTO> implements IEmpleadoRepositorio{
   
    public Empleado (EntityManager em){
        super(em);
    }

    @Override 
    public List<Object[]> empleadoSinUsuario(EntityManager em){ 
       CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
       criteria.select(criteria.from(type));
       String jpql = "select e.empleadoId, e.nombres, e.apellidos from empleado e left join usuario u on e.empleadoid = u.empleadoID where u.empleadoid is null"; 
       Query query = em.createNativeQuery(jpql);
       List<Object[]> emp = query.getResultList();
       return emp;      
    }
   
    @Override
    public List <Object[]>  empleadoNombres(EntityManager em, int u){
       String jpql = "select e.empleadoId, e.Nombres, e.Apellidos from Empleado e join usuario u on e.EmpleadoId = u.EmpleadoID where u.usuarioId = ?";       
       Query query = em.createNativeQuery(jpql);
       query.setParameter(1,u);
       List <Object[]> emp = query.getResultList();
       
       if(!emp.isEmpty()){
           
       return emp; 
       }else{
       return null;
       }            
    }

}
