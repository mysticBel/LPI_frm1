package vista;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class FrmRegCli extends JInternalFrame {
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
				model.addColumn("Código");
				model.addColumn("DNI");
				model.addColumn("Nombre");
				model.addColumn("Apellido");
				model.addColumn("Telefono");
				model.addColumn("Correo");
		
	
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
		
	}


	private String getCodigo() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
}
