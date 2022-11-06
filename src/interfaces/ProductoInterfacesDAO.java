package interfaces;

import java.util.ArrayList;

import entidad.Producto;

public interface ProductoInterfacesDAO {
	// 1. Definimos los procesos
		public int registrarProducto(Producto p); 
		public int actualizarProducto(Producto p);
		public int eliminarProducto(String idProducto);
		
		//Proceso de consulta -  Buscar un producto por codigo
		public Producto buscarProducto(String idProducto);
		//Proceso de Listado - tblProductos
		public ArrayList<Producto> listarProductos();  //import ArrayList
		
}
