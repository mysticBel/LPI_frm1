package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Producto;

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
import java.awt.event.MouseEvent;

public class FrmRegProd extends JInternalFrame implements KeyListener, MouseListener {
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboTipo;
	private JTable tblProductos;
	// Instanciar un objeto para el modelamiento de la tabla tblProductos y agregar columans
	DefaultTableModel model = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd frame = new FrmRegProd();
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
	public FrmRegProd() {
		setTitle("Mantenimiento de Productos");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 506, 350);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(30, 48, 75, 14);
		getContentPane().add(label);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(88, 42, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel label_1 = new JLabel("Producto:");
		label_1.setBounds(30, 73, 75, 14);
		getContentPane().add(label_1);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(88, 70, 86, 20);
		getContentPane().add(txtProducto);

		JLabel label_2 = new JLabel("Tipo:");
		label_2.setBounds(30, 98, 53, 14);
		getContentPane().add(label_2);

		cboTipo = new JComboBox();
		cboTipo.setBounds(88, 94, 123, 20);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		getContentPane().add(cboTipo);

		JLabel label_3 = new JLabel("Cantidad:");
		label_3.setBounds(30, 122, 60, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(88, 119, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(178, 122, 46, 14);
		getContentPane().add(label_4);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(220, 119, 60, 20);
		getContentPane().add(txtPrecio);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(328, 28, 116, 34);
		getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/abrir.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnGuardar.setBounds(328, 78, 116, 34);
		getContentPane().add(btnGuardar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(328, 123, 116, 34);
		getContentPane().add(btnEditar);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 191, 445, 105);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.addKeyListener(this);
		tblProductos.addMouseListener(this);
		scrollPane.setViewportView(tblProductos);
		tblProductos.setFillsViewportHeight(true);
		//Asociar Tabla con el objeto model
		tblProductos.setModel(model);
		//columnas
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Tipo");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
	}

	void ingresar() {
		String cod, prod, nomTipo;
		int cant;
		double pre;
		int tipo;

		cod  = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre  = leerPrecio();
		tipo = leerTipo();
		nomTipo = leerNombreTipo();

		//validación
		if (cod ==null || nomTipo == null || cant == -1 || prod == null) {
			return;  //retorna al proceso de ingresar datos nuevamente
		}else {
		//mostrar los datos en la tabla
		//mostrar un arreglo para almacenar la informacion ingresada
		Object fila[] = {cod, prod, nomTipo, cant, pre};
		//enviar el arreglo al objeto model
		model.addRow(fila);
		}

	}

	private String leerNombreTipo() {
		if(leerTipo() == 0) {
			mensajeError("Por favor selecciona una opcion valida");
		}else {
			return cboTipo.getSelectedItem().toString();
		}
		return null;
	}

	private String leerCodigo() {
		String cod = null;
		// Validar el campo vacio , trim para quitar los espacios
		if(txtCodigo.getText().trim().length() == 0) {
			mensajeError("Por favor ingresar el código del producto");
			/////Formato P0001 o p0001
		}else if(txtCodigo.getText().trim().matches("[pP]\\d{4}")) {
			cod = txtCodigo.getText();
		} else {
			mensajeError("Formato incorrecto ! Ej : P0001 o p0001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
		
		return cod;
		
		//return txtCodigo.getText();
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Error!!!",0);
		
	}

	String leerProducto() {
		String prod = null;
		// validar campo vacio
		if (txtProducto.getText().trim().length() == 0) {
			mensajeError("Ingresa nombre d e Producto");
			txtProducto.setText("");
			txtProducto.requestFocus();
		}//ingresarde 3 a 20 caracteres //espacio para paracetamol forte (\\s)
		else if (txtProducto.getText().trim().matches("[a-zA-Z\\s]{3,20}")){
			prod = txtProducto.getText().trim();
			
		} else {
			mensajeError("Formato Incorrecto !!");
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
			mensajeError("Ingresar la cantidad del producto");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		}
		//validar el ingreso de solo nros enteres
		else {
			try {
				cant = Integer.parseInt(txtCantidad.getText());
				if (cant <=0) {
					mensajeError("Ingresar valores mayores a 0");
					txtCantidad.setText("");
					txtCantidad.requestFocus();
					cant = -1; //se ejecuta linea 167
					
				}
			} catch (NumberFormatException e) {
				// si escribe algo que no es nro
				mensajeError("Ingresar valores enteros");
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
		txtPrecio.setText(pre);
		
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
}












