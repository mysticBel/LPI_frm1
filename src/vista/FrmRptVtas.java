package vista;

import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;


public class FrmRptVtas extends JInternalFrame implements ActionListener {
	private JDateChooser dcFechaIngresada;
	private JButton btnReporte;
	
	//clase Date
	Date fecha = new Date();
	
	
	private JTextArea txtSalida;/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRptVtas frame = new FrmRptVtas();
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
	public FrmRptVtas() {
		setTitle("Reporte de Ventas");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 215, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDel = new JLabel("Del:");
		lblDel.setBounds(20, 59, 39, 24);
		getContentPane().add(lblDel);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(302, 60, 89, 23);
		getContentPane().add(btnReporte);
		
		txtSalida = new JTextArea();
		txtSalida.setBounds(20, 106, 389, 130);
		getContentPane().add(txtSalida);
		
		dcFechaIngresada = new JDateChooser();
		dcFechaIngresada.setBounds(71, 59, 129, 20);
		getContentPane().add(dcFechaIngresada);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		String fechaActual, fechaIngresada;
		fechaActual = fechaActual();
		fechaIngresada = fechaIngresada();
		//mostrar
		txtSalida.setText("Fecha Actual: " + fechaActual + "\n");
		txtSalida.append("Fecha ingresada: " + fechaIngresada);
	}

	private String fechaIngresada() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		return sdf.format(dcFechaIngresada.getDate());
	}

	private String fechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		return sdf.format(fecha);
	}
}
