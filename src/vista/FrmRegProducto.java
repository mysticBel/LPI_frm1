package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Usuario;
import mantenimiento.GestionProductoDAO;
import mantenimiento.GestionTipoCategoriaDAO;
import mantenimiento.GestionUsuarioDAO;
import entidad.Producto;
import entidad.TipoCategoria;
import utils.Alertas;
import validaciones.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class FrmRegProducto extends JInternalFrame implements KeyListener, MouseListener, ActionListener {
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboTipo;
	private JTable tblProductos;
	private JPanel panel;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnNuevo;
	
	
	//instanciamos
			GestionProductoDAO gProd = new GestionProductoDAO();
			GestionTipoCategoriaDAO gTip = new GestionTipoCategoriaDAO();
	// Instanciar un objeto para el modelamiento de la tabla tblProductos y agregar columans
			DefaultTableModel model = new DefaultTableModel();
			private JLabel lblEstado;
			private JTextField txtEstado;
			private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProducto frame = new FrmRegProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegProducto() {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setTitle("Mantenimiento de Productos");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 774, 398);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(542, 73, 75, 14);
		getContentPane().add(label);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(617, 70, 75, 20);
		getContentPane().add(txtCodigo);

		JLabel label_1 = new JLabel("Producto:");
		label_1.setBounds(542, 101, 75, 14);
		getContentPane().add(label_1);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(617, 98, 123, 20);
		getContentPane().add(txtProducto);

		JLabel label_2 = new JLabel("Tipo:");
		label_2.setBounds(542, 133, 53, 14);
		getContentPane().add(label_2);

		cboTipo = new JComboBox();
		cboTipo.setBounds(617, 130, 123, 20);
		getContentPane().add(cboTipo);

		JLabel label_3 = new JLabel("Cantidad:");
		label_3.setBounds(542, 164, 60, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(617, 161, 123, 20);
		getContentPane().add(txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(542, 195, 46, 14);
		getContentPane().add(label_4);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(617, 192, 123, 20);
		getContentPane().add(txtPrecio);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmRegProducto.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(86, 307, 116, 34);
		getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FrmRegProducto.class.getResource("/img/abrir.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnGuardar.setBounds(223, 307, 116, 34);
		getContentPane().add(btnGuardar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(349, 307, 116, 34);
		getContentPane().add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 478, 241);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);
		tblProductos.addKeyListener(this);
		tblProductos.addMouseListener(this);
		tblProductos.setFillsViewportHeight(true);
		//Asociar Tabla con el objeto model
		tblProductos.setModel(model);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 758, 34);
		getContentPane().add(panel);
		
				JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
				panel.add(lblMantenimientoDeProductos);
				lblMantenimientoDeProductos.setForeground(Color.WHITE);
				lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 17));
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(479, 307, 116, 34);
				getContentPane().add(btnEliminar);
				
				btnBuscar = new JButton("");
				btnBuscar.setIcon(new ImageIcon(FrmRegProducto.class.getResource("/img/busca.png")));
				btnBuscar.setBounds(702, 46, 31, 41);
				getContentPane().add(btnBuscar);
		//columnas
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Tipo");
		model.addColumn("Estado");
		//Asociar table con objeto model
		tblProductos.setModel(model);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(542, 227, 46, 14);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setText("");
		txtEstado.setColumns(10);
		txtEstado.setBounds(617, 223, 123, 20);
		getContentPane().add(txtEstado);
		//Cargar data a la tabla
		cargarDataProducto();
		//Mostrar data de la tabla a las cajas de texto
		//mostrarDatos(0);
		
		// cargar data desde la bd a el cbobox
				cargarDataCombobox();
	}
	
	/*

	private void cargarDataProducto() {
		// TODO Auto-generated method stub
		//PASO 1 : Limpiar la tabla
				model.setRowCount(0);
				//PASO 2 : Obtener el resultado
				ArrayList<Producto> list = gProd.listarProductos();
				//PASO 3 : bucle para el recorrido
				for( Producto p : list) {
					Object fila [] = {p.getIdProducto(),
									  p.getDescripcion(),
									  p.getStock(),
									  p.getPrecio(),
									  p.getIdCategoria(),
									  p.getEstado()
									};
					//añadir fila a la tabla
					model.addRow(fila);
				}		
	}
	*/

	void ingresar() {
		String cod, prod, nomTipo;
		int cant;
		double pre;
		int tipo, estado;

		cod  = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre  = leerPrecio();
		tipo = leerTipo();
		nomTipo = leerNombreTipo();
		estado = leerEstado();

		//validación
		if (cod ==null || nomTipo == null || cant == -1 || pre == -1 ||prod == null) {
			return;  //retorna al proceso de ingresar datos nuevamente
		}else {
			//Paso 1 : Crear un objeto de la clase Producto - instanciamos de la clase Producto
			Producto p = new Producto();
			//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
			p.setIdProducto(cod);
			p.setDescripcion(prod);
			p.setStock(cant);
			p.setPrecio(pre);
			p.setIdCategoria(tipo);
			p.setEstado(estado);
			//Paso 3 : Llamar al proceso de registro - gestionProductoDAO, lo hemos instanciado en el constructor
			int res = gProd.registrarProducto(p);
			//Validar el resultado del proceso de registro
			if(res == 0) {
				Alertas.mensajeError(":( Hubo un error en el registro");
			}else {
				Alertas.mensajeExitoso("Usuario registrado con éxito !");
				cargarDataProducto(); //cargar datos a la tabla
			}
		
		}

	}



	private int leerEstado() {
		int estado =-1;
		estado = Integer.parseInt(txtEstado.getText());
		return estado;
	}

	private String leerNombreTipo() {
		if(leerTipo() == 0) {
			Alertas.mensajeError("Por favor selecciona una opcion valida");
		}else {
			return cboTipo.getSelectedItem().toString();
		}
		return null;
	}

	private String leerCodigo() {
		String cod = null;
		// Validar el campo vacio , trim para quitar los espacios
		if(txtCodigo.getText().trim().length() == 0) {
			Alertas.mensajeError("Por favor ingresar el código del producto");
			/////Formato P0001 o p0001
		}else if(txtCodigo.getText().trim().matches(Validaciones.COD_PRODUCTO)) {
			cod = txtCodigo.getText();
		} else {
			Alertas.mensajeError("Formato incorrecto ! Ej : P0001 o p0001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
		
		return cod;
		
		//return txtCodigo.getText();
	}


	String leerProducto() {
		String prod = null;
		// validar campo vacio
		if (txtProducto.getText().trim().length() == 0) {
			Alertas.mensajeError("Ingresa nombre d e Producto");
			txtProducto.setText("");
			txtProducto.requestFocus();
		}//ingresarde 3 a 20 caracteres //espacio para paracetamol forte (\\s)
		else if (txtProducto.getText().trim().matches(Validaciones.NOM_PRODUCTO)){
			prod = txtProducto.getText().trim();
			
		} else {
			Alertas.mensajeError("Formato Incorrecto !!");
			txtProducto.setText("");
			txtProducto.requestFocus();
			
		}
		return prod;
	}
	
	int leerTipo() {
		
		return cboTipo.getSelectedIndex();
	}

	int leerCantidad() {
		
		
		int cant = -1;
		//si hay campo vacio en el form
		if(txtCantidad.getText().trim().length()== 0) {
			Alertas.mensajeError("Ingresar la cantidad del producto");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		}
		//validar el ingreso de solo nros enteres
		else {
			try {
				cant = Integer.parseInt(txtCantidad.getText());
				if (cant <=0) {
					Alertas.mensajeError("Ingresar valores mayores a 0");
					txtCantidad.setText("");
					txtCantidad.requestFocus();
					cant = -1; //se ejecuta linea 167
					
				}
			} catch (NumberFormatException e) {
				// si escribe algo que no es nro
				Alertas.mensajeError("Ingresar valores enteros");
				txtCantidad.setBackground(Color.RED);
				txtCantidad.setText("");
				txtCantidad.requestFocus();
			}
		}
		return cant;
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblProductos) {
			keyReleasedTblProductos(e);
		}
		if (e.getSource() == txtCantidad) {
			keyReleasedTxtCantidad(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtCantidad(KeyEvent e) {
		txtCantidad.setBackground(Color.WHITE);
	}
	
	//Metodo para mostrar datos de la tabla en la caja de texto
	private void mostrarDatos(int fila) {
		//Paso 1 : Obtener los datos de la tabla
		String cod, prod, cant, pre ,tipo, estado;
		cod = tblProductos.getValueAt(fila, 0).toString(); //columna de codigo
		prod = tblProductos.getValueAt(fila, 1).toString();		
		cant = tblProductos.getValueAt(fila, 2).toString();
		pre = tblProductos.getValueAt(fila, 3).toString();
		tipo = tblProductos.getValueAt(fila, 4).toString();
		estado = tblProductos.getValueAt(fila, 5).toString();
	
		// Paso 2: Mostrar los datos obtenidos en las cajas de texto
		txtCodigo.setText(cod);
		txtProducto.setText(prod);
		txtCantidad.setText(cant);
		txtPrecio.setText(pre); 
		cboTipo.setSelectedItem(tipo);
		txtEstado.setText(pre); 
		
		/* //Paso 1 : Obtener los datos de la tabla
		String cod, prod, tipo, pre , cant;
		cod = tblProductos.getValueAt(fila, 0).toString(); //columna de codigo
		prod = tblProductos.getValueAt(fila, 1).toString();		
		tipo = tblProductos.getValueAt(fila, 2).toString();
		cant = tblProductos.getValueAt(fila, 3).toString();
		pre = tblProductos.getValueAt(fila, 4).toString();
	
		// Paso 2: Mostrar los datos obtenidos en las cajas de texto
		txtCodigo.setText(cod);
		txtProducto.setText(prod);
		cboTipo.setSelectedItem(tipo);
		txtCantidad.setText(cant);
		txtPrecio.setText(pre); */
		
	}
	public void mouseClicked(MouseEvent e) { 
		if (e.getSource() == tblProductos) {
			mouseClickedTblProductos(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblProductos(MouseEvent e) {
		//obtener el valor de la fila seleccionada
		int fila = tblProductos.getSelectedRow();
		//mostrar datos
		mostrarDatos(fila);
	}
	protected void keyReleasedTblProductos(KeyEvent e) { //cambia las filas con las direccionales del keyboard
		//obtener el valor de la fila seleccionada
			int fila = tblProductos.getSelectedRow();
			//mostrar datos
			mostrarDatos(fila);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigo.setText("");
		txtProducto.setText("");
		//cboTipos.
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarProducto();
	}

	private void actualizarProducto() {
		
		String cod, prod, nomTipo;
		int cant;
		double pre;
		int tipo, estado;
	
		// ENTRADAS
		cod  = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre  = leerPrecio();
		tipo = leerTipo();
		nomTipo = leerNombreTipo();
		estado = leerEstado();
		
		// VALIDAR
		if(cod ==null || nomTipo == null || cant == -1 || pre == -1 ||prod == null) {
			return; // no se ejecuta
		} else {
			
			//Paso 1 : Crear un objeto de la clase Producto - instanciamos de la clase Producto
			Producto p = new Producto();
			//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
			p.setIdProducto(cod);
			p.setDescripcion(prod);
			p.setStock(cant);
			p.setPrecio(pre);
			p.setIdCategoria(tipo);
			p.setEstado(estado);
			//Paso 3 : Llamar al proceso de registro - gestionProductoDAO, lo hemos instanciado en el constructor
			int res = gProd.actualizarProducto(p);
			//Validar el resultado del proceso de registro
			if(res == 0) {
				Alertas.mensajeError(":( Hubo un error en la actualización");
			}else {
				Alertas.mensajeExitoso("Producto ACTUALIZADO con éxito !");
			    cargarDataProducto(); //cargar datos a la tabla
			}
	
						
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarProducto();
	}

	private void eliminarProducto() {
		String cod; 
		int opcion;
		// 1. Obtener el codigo ingresado
			cod = leerCodigo();
			//validacion
			if(cod == null) {
				return;
			}else {
				// Mensaje de Confirmacion
				opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar ?", "Sistema", JOptionPane.YES_NO_OPTION);
				if(opcion == 0) { // SI
					//Ejecutar el proceso de tipo int
					int ok = gProd.eliminarProducto(cod);
					// Validar el resultado del proceso
					if(ok == 0) {
						Alertas.mensajeError("Codigo de Producto no existe");
					}else {
						Alertas.mensajeExitoso("Producto ELIMINADO");
						cargarDataProducto();
					}
				}
			}
	}
	
	
	
	
	//metodo encargado de cargar los datos a la tabla
	private void cargarDataProducto(){
		//PASO 1 : Limpiar la tabla
		model.setRowCount(0);
		//PASO 2 : Obtener el resultado
		ArrayList<Producto> list = gProd.listarProductos();
		//PASO 3 : bucle para el recorrido
		for( Producto p : list) {
			Object fila [] = {	p.getIdProducto(),
								p.getDescripcion(),
								p.getStock(),
								p.getPrecio(),
								p.getIdCategoria(),
								p.getEstado()
							};
			//añadir fila a la tabla
			model.addRow(fila);
		}		
	}
	
	
	//Metodo cargar data al cbo
	private void cargarDataCombobox() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<TipoCategoria> list = gTip.listarTipoCategoria();
		// 2. Validar el resultado del proceso
		if(list.size() == 0) {
			Alertas.mensajeError("Lista vacia");
		} else {
			cboTipo.addItem("Seleccione ...");
			for(TipoCategoria tipCat : list) {
				cboTipo.addItem(tipCat.getIdtipo() + " " + tipCat.getDescripcionTipo());
			}
		}
	}
}












