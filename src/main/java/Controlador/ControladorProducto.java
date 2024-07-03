package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.ClassProductoImp;

import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl3 producto= new TblProductocl3();
        ClassProductoImp crud= new ClassProductoImp();
        List<TblProductocl3> listadoProducto=crud.ListadoProducto();

        //invocamos el listado  de productos para la vista

        request.setAttribute("listadoproductos", listadoProducto);

        //Redireccionamos

        request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//recuperamos los valores del formulario...
				String nombre=request.getParameter("nombre");
				
				String precioVentaStr = request.getParameter("precioventa");
				Double precioVenta = null;
				try {
				    precioVenta = Double.parseDouble(precioVentaStr);
				} catch (NumberFormatException e) {
				    // Maneja el error si el valor no puede ser convertido a Double
				    e.printStackTrace();
				    // Puedes lanzar una excepción, redirigir a una página de error, etc.
				}
				String precioCompraStr = request.getParameter("preciocompra");
				Double precioCompra = null;

				try {
				    precioCompra = Double.parseDouble(precioCompraStr);
				} catch (NumberFormatException e) {
				    // Maneja el error si el valor no puede ser convertido a Double
				    e.printStackTrace();
				    // Puedes lanzar una excepción, redirigir a una página de error, etc.
				}

				String estado=request.getParameter("estado");
				String desc=request.getParameter("descripcion"); 
				
				
				//instanciar las respectivas entidades...
				TblProductocl3 producto=new TblProductocl3();
				ClassProductoImp crud=new ClassProductoImp();
				//asignamos valores
				
				producto.setNombrecl3(nombre);
				producto.setPrecioventacl3(precioVenta);
				producto.setPreciocompcl3(precioCompra);
				producto.setEstadocl3(estado);
				producto.setDescripcl3(desc);
				
				
				/*cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setDni(dni);
				cliente.setEmail(email);
				cliente.setTelf(telef);
				cliente.setSexo(sexo);
				cliente.setNacionalidad(nacionalidad);*/
				//invocamos la metodo registrar...
				crud.RegistrarProducto(producto);
				//redireccionamos
				request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
		
		
		
	}

}
