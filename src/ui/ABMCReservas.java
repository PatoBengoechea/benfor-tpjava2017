package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entities.Elemento;
import entities.Persona;
import entities.Reserva;
import controlers.CtrlABMCPersona;
import controlers.CtrlABMCReserva;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ABMCReservas {

	private JFrame frame;
	private JTable table;
	static private Persona usuAct;
	public ArrayList<Reserva> reservasCliente;
	private CtrlABMCReserva ctrlR;
	private DefaultTableModel modelo;
	private JLabel lblResultado;
	Object[] columnNames = {"IdReserva", "Fecha Inicio", "Fecha Fin", "Elemento","Persona"};
	String[][] datosnuevos = {};
	/**
	 * Launch the application.
	 */
	public static void main(Persona usuActual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuAct = new Persona();
					usuAct = usuActual;
					ABMCReservas window = new ABMCReservas();
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
	public ABMCReservas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table = new JTable();
		ctrlR = new CtrlABMCReserva();
		lblResultado = new JLabel("----");
		reservasCliente = new ArrayList<Reserva>();
		actualizarTabla();
		
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Reservar reser = new Reservar();
				ABMCReservas abmreser = new ABMCReservas();
				reser.main(null);
			}
		});
		
		this.frame.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton)
							.addGap(128)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)
							.addGap(56))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(252)
					.addComponent(lblResultado)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblResultado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	private void actualizarTabla() {
		reservasCliente = ctrlR.getAll();
		modelo = new DefaultTableModel(datosnuevos, columnNames);
		while(modelo.getRowCount()>0){
			modelo.removeRow(0);}
			if(reservasCliente.isEmpty()){
				lblResultado.setText("No hay elementos");
			}
			else{
			for (Reserva res : reservasCliente) {
					if (usuAct.equals(res.getPersona()))
					{
					Object[] newRow= {res.getIdReserva(),res.getFechaInicio(),res.getFechaFin(), res.getElemento().getDescripcion(), res.getPersona().getIdPersona()};
					modelo.addRow(newRow);
					}
			}
					table.setModel(modelo);
			}
		}	
	}

