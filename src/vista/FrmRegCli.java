package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hilos.HiloReloj;
import model.Producto;
import validaciones.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class FrmRegCli extends JInternalFrame implements KeyListener {
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JScrollPane scrollPane;
	private JTable tblClientes;
	// Instanciar un objeto para el modelamiento de la tabla tblProductos y agregar columans
		DefaultTableModel model = new DefaultTableModel();
		private JLabel lblError;
		private JLabel lblRelojCli;
		private JLabel lblErrorNombre;
		private JLabel lblErrorDni;
		private JLabel lblErrorApe;
		private JLabel lblErrorTelef;
		private JLabel lblErrorCorreo;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegCli frame = new FrmRegCli();
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
	public FrmRegCli() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 564, 408);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(30, 48, 75, 14);
		getContentPane().add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(88, 42, 86, 20);
		getContentPane().add(txtCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 105, 75, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 102, 271, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(30, 130, 53, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(30, 154, 60, 14);
		getContentPane().add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(88, 151, 86, 20);
		getContentPane().add(txtTelefono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(30, 179, 46, 14);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(88, 176, 271, 20);
		getContentPane().add(txtCorreo);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(385, 24, 116, 34);
		getContentPane().add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnGuardar.setBounds(385, 70, 116, 34);
		getContentPane().add(btnGuardar);
		
		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Clientes");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);
		
		txtApellido = new JTextField();
		txtApellido.setText("");
		txtApellido.setColumns(10);
		txtApellido.setBounds(88, 127, 271, 20);
		getContentPane().add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(30, 80, 75, 14);
		getContentPane().add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setText("");
		txtDNI.setColumns(10);
		txtDNI.setBounds(88, 74, 86, 20);
		getContentPane().add(txtDNI);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 226, 491, 127);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);
		
		//Asociar Tabla con el objeto model
				tblClientes.setModel(model);	
		//columnas
				model.addColumn("C�digo");
				model.addColumn("DNI");
				model.addColumn("Nombre");
				model.addColumn("Apellido");
				model.addColumn("Telefono");
				model.addColumn("Correo");
				
		lblError = new JLabel("*");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		lblError.setBounds(183, 47, 46, 14);
		getContentPane().add(lblError);
		
		lblRelojCli = new JLabel("hh:mm:ss");
		lblRelojCli.setBounds(409, 154, 92, 14);
		getContentPane().add(lblRelojCli);
		
		lblErrorNombre = new JLabel("*");
		lblErrorNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(363, 105, 46, 14);
		lblErrorNombre.setVisible(false);
		getContentPane().add(lblErrorNombre);
		
		lblErrorDni = new JLabel("*");
		lblErrorDni.setForeground(Color.RED);
		lblErrorDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorDni.setBounds(184, 80, 46, 14);
		lblErrorDni.setVisible(false);
		getContentPane().add(lblErrorDni);
		
		lblErrorApe = new JLabel("*");
		lblErrorApe.setForeground(Color.RED);
		lblErrorApe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorApe.setBounds(363, 130, 46, 14);
		lblErrorApe.setVisible(false);
		getContentPane().add(lblErrorApe);
		
		lblErrorTelef = new JLabel("*");
		lblErrorTelef.setForeground(Color.RED);
		lblErrorTelef.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorTelef.setBounds(183, 154, 46, 14);
		lblErrorTelef.setVisible(false);
		getContentPane().add(lblErrorTelef);
		
		lblErrorCorreo = new JLabel("*");
		lblErrorCorreo.setForeground(Color.RED);
		lblErrorCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorCorreo.setBounds(363, 179, 46, 14);
		lblErrorCorreo.setVisible(false);
		getContentPane().add(lblErrorCorreo);
	
		//reloj sincronizado
		mostrarHora();
	}

	
	
	
	private void mostrarHora() {
		HiloReloj h = new HiloReloj(lblRelojCli);
		h.start();
		
	}

	void ingresar(){
		
		//1. Declaramos las variables
		String cod, nomb, ape, telf, correo, dni;
		//entrada de datos:
		cod = getCodigo();
		nomb = getNombre();
		ape = getApellido();
		telf = getTelefono();
		correo = getCorreo();
		dni = getDni();
		
		
		// -- validacion
		if (cod ==null || dni ==null  ) {
			return; //se cancela el guardar datos
		} else {
			Object fila[] = {   cod,
								dni,
								nomb,
								ape,
								telf,
								correo
							};
			model.addRow(fila); //aparece en la tabla los datos
		}
		
	}


	private String getCodigo() {
		// 2. Formato CL001 - cl001
		String cod = null;
		///campo vacio -validacion
		if ( txtCodigo.getText().trim().length() == 0) {
			mensajeError("Por favor, ingresar el c�digo del cliente");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			lblError.setVisible(true); // 2.a. para que aparezca el arterisco 
		} //Formato CL001 - cl001
		else if (txtCodigo.getText().trim().matches(Validaciones.COD_CLIENTE )) {
			cod = txtCodigo.getText().trim();
		}else {
			mensajeError("Formato invalido! , Ejem CL001 o cl001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			lblError.setVisible(true);  //para que aparezca el arterisco 
		}
		return cod;
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);
		
	}

	private String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getApellido() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getTelefono() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getCorreo() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getDni() {
		String dni =null;
		///campo vacio -validacion
				if ( txtDNI.getText().trim().length() == 0) {
					mensajeError("Por favor, ingresar el dni del cliente");
					txtDNI.setText("");
					txtDNI.requestFocus();
					lblError.setVisible(true); // 2.a. para que aparezca el arterisco 
				} //Formato CL001 - cl001
				else if (txtDNI.getText().trim().matches(Validaciones.DNI_CLIENTE )) {
					dni = txtDNI.getText().trim();
				}else {
					mensajeError("Formato invalido! ,digite 8 n�meros");
					txtDNI.setText("");
					txtDNI.requestFocus();
					lblError.setVisible(true);  //para que aparezca el arterisco 
				}
		return dni;
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCodigo) {
			keyReleasedTxtCodigo(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtCodigo(KeyEvent e) {
		lblError.setVisible(false);
	}
}
