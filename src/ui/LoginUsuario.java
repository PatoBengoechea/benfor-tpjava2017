package ui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Persona;
import controlers.CtrlABMCPersona;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;

public class LoginUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsu;
	private JTextField txtPass;
	private JLabel lblEncontro;
	public CtrlABMCPersona ctrl;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUsuario frame = new LoginUsuario();
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
	public LoginUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ctrl = new CtrlABMCPersona();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Persona usu = new Persona();
				Persona per = new Persona();
				usu.setUsuario(txtUsu.getText());
				usu.setContraseña(txtPass.getText());
				per = ctrl.buscarUsuario(usu);
					if (per != null) {
				lblEncontro.setText("Bienvenido " + per.getNombre());
				}
				else {
					lblEncontro.setText("Usuario no encontrado");
				}
				
			}


		});
		btnIngresar.setBounds(158, 206, 117, 29);
		panel.add(btnIngresar);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(158, 34, 130, 26);
		panel.add(txtUsu);
		txtUsu.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(158, 111, 130, 26);
		panel.add(txtPass);
		txtPass.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(46, 39, 61, 16);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(46, 116, 76, 16);
		panel.add(lblContrasea);
		
		JLabel lblEncontro = new JLabel("--");
		lblEncontro.setBounds(173, 178, 61, 16);
		panel.add(lblEncontro);
	}
}
