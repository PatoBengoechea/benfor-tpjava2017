package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import entities.*;
import controlers.CtrlABMCElemento;
import controlers.CtrlABMCTipoElemento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionRecintos {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtUbicacion;
	private JTextField txtDesc;
	private JTextField txtCap;
	private JLabel lblResultado;
	private JComboBox<String> comboBox;
	private JComboBox<String> cmbTipos;
	private TipoElemento tipo;
	private CtrlABMCElemento ctrlE;
	private CtrlABMCTipoElemento ctrlT;
	public ArrayList<TipoElemento> tiposElementos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionRecintos window = new GestionRecintos();
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
	public GestionRecintos() {
		initialize();
		carga();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ctrlE = new CtrlABMCElemento();
		ctrlT = new CtrlABMCTipoElemento();
		comboBox = new JComboBox<String>();
		//tiposElementos.addAll(ctrlT.getAll());
		
		JLabel lblNewLabel = new JLabel("Id Recinto");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ubicacion");
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		
		txtCap = new JTextField();
		txtCap.setColumns(10);
		
		cmbTipos = new JComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Recinto");
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		
		lblResultado = new JLabel("-   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(cmbTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnAgregar))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(lblResultado)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAgregar)
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void agregar() {
		TipoElemento tipo = null;
		String desc = null;
		desc = this.txtDesc.getText();
		int cap = Integer.parseInt(this.txtCap.getText());
		String ubi = null;
		ubi = this.txtUbicacion.getText();
		String sel = null;
		sel = cmbTipos.getSelectedItem().toString();
		for (TipoElemento tipoElemento : tiposElementos) {
			if(tipoElemento.getDescTipo().equals(sel)){
				tipo = tipoElemento;
			}
		}
		Elemento elem = new Elemento(desc,cap,ubi,tipo);
		this.lblResultado.setText("Agrego: " + desc + "  Capacidad: " + cap + "  Ubicacion: " + ubi + "  Tipo: " + tipo.getDescTipo());
		ctrlE.Add(elem);
							}
	private void carga() {
		tiposElementos = new ArrayList<TipoElemento>();
		tiposElementos = ctrlT.getAll();
		for (TipoElemento tipoElemento : tiposElementos) {
			cmbTipos.addItem(tipoElemento.getDescTipo());
		}
	}
	}

