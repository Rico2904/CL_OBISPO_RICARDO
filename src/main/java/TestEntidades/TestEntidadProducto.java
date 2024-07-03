package TestEntidades;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {
	public static void main(String[] args) {           
        
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		                                               
		//asigamos valores                             
		                                               
		producto.setNombrecl3("Leche");            
		producto.setPreciocompcl3(3);                  
		producto.setPrecioventacl3(4);                 
		producto.setEstadocl3("Nuevo");                
		producto.setDescripcl3("Lácteos");       
	                                                   
		                                               
		//invocamos al metodo registrar . .            
		                                               
		crud.RegistrarProducto(producto);              
		                                               
		                                               
	                                                   
	}                                                  
}
