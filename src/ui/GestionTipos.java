package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import controlers.CtrlABMCTipoElemento;
import entities.TipoElemento;
import ui.Reservar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class GestionTipos {

	private JFrame frame;
	private JTextField txtDesc;
	private JSpinner spinner;
	private SpinnerNumberModel modelos;
	CtrlABMCTipoElemento ctrltipo;
	private JLabel lblResultado;

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
		
		JButton btnEliminarTipo = new JButton("Eliminar");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		
		JLabel lblCantidadDias = new JLabel("Cantidad Dias Maximos Reserva");
		
		lblResultado = new JLabel("-   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCantidadDias)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreNuevoTipo, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(txtDesc, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEliminarTipo)
							.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
							.addComponent(btnAgregar))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addGap(39)))
					.addGap(77))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreNuevoTipo)
						.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadDias)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(lblResultado)
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminarTipo)
						.addComponent(btnAgregar))
					.addGap(33))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void agregar() {
		String desc = null;
		desc = txtDesc.getText();
		int diasMax = 0;
		diasMax = Integer.parseInt((spinner.getModel().getValue().toString()));
		TipoElemento tiponuevo = new TipoElemento(desc,diasMax);
		this.lblResultado.setText("Agrego: " + desc + " Dias Max:  " + diasMax);
		//ctrltipo.Add(tiponuevo);		
	}
	
	protected void eliminar(){
		
		//no hace nada
	}
}
