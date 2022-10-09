package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloEnvio;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor extends JFrame implements ActionListener {

	private JPanel contentPane;
	public static JTextArea txtS;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor();
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
	public Editor() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(26, 213, 89, 23);
		contentPane.add(btnEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 38, 367, 151);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
	}
	
	//hilo
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		//1 
		HiloEnvio h1 = new HiloEnvio();
		HiloEnvio h2 = new HiloEnvio();
		//2
		h1.start();
		h2.start();
	}
}
