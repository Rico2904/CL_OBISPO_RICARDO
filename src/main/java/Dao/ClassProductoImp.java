package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;

import model.TblProductocl3;

public class ClassProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		// establecer conexion  con la unidad de persistencia . . . 
				EntityManagerFactory pro= Persistence.createEntityManagerFactory("CL3_OBISPO_RICARDO");
						 
				//permite gestionar entidades
				EntityManager em=pro.createEntityManager();
				//iniciamos transaccion
				em.getTransaction().begin();
				
				//registramos
				em.persist(producto);
				
				//confirmamos
				em.getTransaction().commit();
				
				//imprimmos
				
				System.out.println("Producto registrado correctanmente en la BD");
				
				//cerramos transaccion
				
				em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		//establecemos conexion con la unidad de persistencia..
		EntityManagerFactory em=Persistence.createEntityManagerFactory("CL3_OBISPO_RICARDO");
		//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//actualizar
		emanager.merge(producto);
		//emitimos el mensaje
		System.out.println("Producto Actualizado en BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public void EliminarCliente(TblProductocl3 producto) {
		//establecemos la conexion con la unidad de persistencia.
				EntityManagerFactory em=Persistence.createEntityManagerFactory("CL3_OBISPO_RICARDO");
				//gestionar las entidades
				EntityManager emanager=em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblProductocl3 elim=emanager.merge(producto);
				//procedemos a eliminar
				emanager.remove(elim);
				//emitimos mensaje por consola
				System.out.println("Producto eliminado de la BD");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();	
		
	}

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		//establecer la conexion con la unidad de persistencia
				EntityManagerFactory em=Persistence.createEntityManagerFactory("CL3_OBISPO_RICARDO");
				//gestionar las entidades
				EntityManager emanager=em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//recuperamos el codigo a buscar..
				TblProductocl3 buscarpro=emanager.find(TblProductocl3.class,producto.getIdproductoscl3());
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
				//retornamos el cliente buscado de la BD.
				return buscarpro;
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		 //establecer la conexion con la unidad de persistencia
        EntityManagerFactory em= Persistence.createEntityManagerFactory("CL3_OBISPO_RICARDO");
        //gestionar las entidades
        EntityManager emanager= em.createEntityManager();
        //inicar la transaccion
        emanager.getTransaction().begin();
        //recuperamos el listado de productos de la base de datos
        List<TblProductocl3> listado= emanager.createQuery("select c from TblProductocl2 c",TblProductocl3.class).getResultList();
        //confirmamos 
        emanager.getTransaction().commit();
        //cerramos
        emanager.close();
        return listado;
		
	}

}
