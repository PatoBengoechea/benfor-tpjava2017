package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import controlers.CtrlABMCTipoElemento;
import entities.TipoElemento;
import ui.Reservar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionTipos {

	private JFrame frame;
	private JTextField txtDesc;
	CtrlABMCTipoElemento ctrltipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionTipos window = new GestionTipos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionTipos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ctrltipo = new CtrlABMCTipoElemento();
		
		JLabel lblNombreNuevoTipo = new JLabel("Nombre Nuevo Tipo:");
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnEliminarTipo = new JButton("Eliminar");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreNuevoTipo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDesc, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEliminarTipo)
							.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
							.addComponent(btnAgregar)))
					.addGap(77))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreNuevoTipo)
						.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminarTipo)
						.addComponent(btnAgregar))
					.addGap(33))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void agregar() {
		String desc = null;
		TipoElemento tiponuevo = new TipoElemento(txtDesc.getText());
		ctrltipo.Add(tiponuevo);		
	}
	
	protected void eliminar(){
		
		//no hace nada
	}

}
