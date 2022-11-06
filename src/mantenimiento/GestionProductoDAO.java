package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Producto;
import entidad.Usuario;
import utils.MySQLConexion8;

public class GestionProductoDAO {
	//Logica de Negocio
	// REGISTRO -  INSERT
	
	public int registrarProducto(Producto p) {
		int res = 0;
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//		
			String sql = "insert into tb_productos values ( ?, ?, ?, ?, ?, ?)";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			pstm.setString(1,  p.getIdProducto());
			pstm.setString(2,  p.getDescripcion());
			pstm.setInt(3,  p.getStock());
			pstm.setDouble(4,  p.getPrecio());
			pstm.setInt(5,  p.getIdCategoria());
			pstm.setInt(6,  p.getEstado());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción del registro " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas prácticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e2) {  //importar
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
	}
	
	
	// ACTUALIZAR  -  UPDATE
	
	public int actualizarProducto(Producto p) {
		int res = 0;
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//		
			String sql = "UPDATE  tb_productos set descripcion = ? , stock = ?, precio = ?, idtipo = ?, estado = ? where idprod = ?"; //se copia tal y como esta en mysql
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			
			pstm.setString(1,  p.getDescripcion());
			pstm.setInt(2,  p.getStock());
			pstm.setDouble(3,  p.getPrecio());
			pstm.setInt(4,  p.getIdCategoria());
			pstm.setInt(5,  p.getEstado());
			pstm.setString(6,  p.getIdProducto());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción de actualización  " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas prácticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e2) {  //importar
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
	}
	
	// ELIMINAR  -  DELETE
	
		public int eliminarProducto(String idProducto) {
			int res = 0;
			Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
			PreparedStatement pstm = null; 
			try {
				// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
				con = MySQLConexion8.getConexion();
				// PASO 2 : Registro ->Definir la instruccion SQL 
				//		
				String sql = "delete from  tb_productos where idprod = ?"; //se copia tal y como esta en mysql
				// PASO 3 : Obtener los comandos QL --> Enviar la instruccion al objeto pstm
				   pstm = con.prepareStatement(sql);
				// PASO 4 : Obtener los parametros
					pstm.setString(1, idProducto );			
				// PASO 5 : ejecucion de la instruccion
					res = pstm.executeUpdate();   //retorna int
				
			} catch (Exception e) {
				System.out.println(">>>>  Error en la instrucción SQL - eliminar <<<< " + e.getMessage());
			} finally {   //para cerrar la conexion por buenas prácticas
				try {
					if(pstm !=null) {
						pstm.close();
					}
					if(con !=null) {
						con.close();
					}
				} catch (SQLException e2) {  //importar
					System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
				}
			}
			
			return res;
		}
		
		// cargar productos a la tabla
		public ArrayList<Producto> listarProductos() {
			ArrayList<Producto> listaProd = new ArrayList<Producto>();  //inicializa por defecto en null un arraylist, almacena la lista de usuarios este objeto
			Connection con = null; 
			PreparedStatement pstm = null;
			//Como es consulta, necesito ResultSet
			ResultSet res = null;
			Producto prod = null;  //para asignarle valores a la listaUser, debemos tener un objeto Usuario
			
			try {
				// completar el sabado
				//La parte lógica de la conexión
				// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
				   con = MySQLConexion8.getConexion();
				/* PASO 2 : Consultar ->Definir la instruccion SQL */
				   String sql = "select *  from  tb_productos";
				// PASO 3 : Enviar la instruccion al objeto pstm --> Obtener los comandos SQL
				   pstm = con.prepareStatement(sql);
				// PASO 4 : Obtener los parametros --no hay
				// PASO 5 : ejecucion de la instruccion
					res = pstm.executeQuery();   //el resultado de la consulta lo obtiene el objeto res
				 //	**PASO 6 : Bucle --> Realizar el recorrido al objeto res
					while(res.next()) {
						// Crear objeto de tipo Usuario
						prod = new Producto();
						// setear --> Asignar los valores obtenidos del obj res a los atrib. privados
						prod.setIdProducto(res.getString(1));
						prod.setDescripcion(res.getString(2)); 
						prod.setStock(res.getInt(3));
						prod.setPrecio(res.getDouble(4));
						prod.setIdCategoria(res.getInt(5));
						prod.setEstado(res.getInt(6));
					
						
						
						// Añadir el objeto a la lista
						listaProd.add(prod);
					}
			
			} catch (Exception e) {
				System.out.println(">>>> Error en la instrucción SQL - Consultar " + e.getMessage());
			} finally {
				try {
					if(pstm !=null) pstm.close();
					if(res !=null) res.close();
					if(con !=null) con.close();
						
				} catch (SQLException e2) {
					System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
				}
		   }
			
			return listaProd;
		}
}
