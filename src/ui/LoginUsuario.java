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
import javax.swing.JToolBar;
import java.awt.FlowLayout;

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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reservar vc = new Reservar();
				LoginUsuario vlogin = new LoginUsuario();
				vc.main(null);
				vlogin.setVisible(false);			
			}


		});
		btnIngresar.setBounds(253, 201, 117, 29);
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
		
		JLabel lblContrasea = new JLabel("Contrasea");
		lblContrasea.setBounds(46, 116, 76, 16);
		panel.add(lblContrasea);
		
		JLabel lblEncontro_1 = new JLabel("--");
		lblEncontro_1.setBounds(173, 178, 61, 16);
		panel.add(lblEncontro_1);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nuevoUser vc = new nuevoUser();
				LoginUsuario vlogin = new LoginUsuario();
				vc.main(null);
				vlogin.setVisible(false);
			}
		});
		btnRegistrarse.setBounds(46, 204, 89, 23);
		panel.add(btnRegistrarse);
	}
}
