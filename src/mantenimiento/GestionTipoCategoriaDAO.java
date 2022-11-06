package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.TipoCategoria;
import interfaces.TipoCategoriaInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoCategoriaDAO implements TipoCategoriaInterfacesDAO {

	@Override
	public ArrayList<TipoCategoria> listarTipoCategoria() {
		ArrayList<TipoCategoria> lista = new ArrayList<TipoCategoria>(); //null
		TipoCategoria tipCat = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
						con = MySQLConexion8.getConexion();
						// PASO 2 : Registro ->Definir la instruccion SQL 
						//			insert into tb_usuarios values (null, "Mario", "Perez", "U004", "1004", "2020-08-22", default, default);
						String sql = " SELECT * FROM tb_categorias";
						// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
						pstm = con.prepareStatement(sql);
						// PASO 4 : Obtener los parametros (no hay)
						// PASO 5 : ejecucion de la instruccion
						res = pstm.executeQuery();   
						//PASO 6 :
						while(res.next()){
							tipCat = new TipoCategoria();
							//setear
							tipCat.setIdtipo(res.getInt(1));
							tipCat.setDescripcionTipo(res.getString(2));
							//enviar a la lista
							lista.add(tipCat);
						}
			
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL " + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(res != null) res.close();
				if(con!= null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD " + e2.getMessage());
			}finally {
			}
		}
		return lista;
	}

}
