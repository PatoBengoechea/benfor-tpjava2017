package ui;

import entities.Elemento;

import java.sql.Date;

import entities.TipoElemento;
import entities.Persona;
import entities.Reserva;
import javax.swing.JSpinner;
import java.awt.EventQueue;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import controlers.CtrlABMCElemento;
import controlers.CtrlABMCReserva;
import controlers.CtrlABMCTipoElemento;
import javax.swing.ComboBoxModel;

public class Reservar {

	public static Persona usuarioAct;
	public JFrame frame;
	Object[][] datos = {};
	private JTextField txtFechaInicio;
	private DefaultTableModel modelo;
	private DefaultTableModel nuevomodelo;
	private JScrollPane scrollLista;
	public ArrayList<Elemento> elementos;
	public ArrayList<Elemento> reservasCliente;
	public ArrayList<Reserva> reservas;
	public ArrayList<TipoElemento> tiposElementos;
	public CtrlABMCTipoElemento ctrlTipoElemento;
	public CtrlABMCReserva ctrlReserva;
	CtrlABMCElemento ctrlElemento;
	public ArrayList<String> tipos;
	private JLabel lblResultado;
	private JTable table;
	private JTextField txtFechaFin;
	Object[] columnNames = {"Id", "Capacidad", "Descripcion", "ubicacion","IdTipo"};
	String[][] datosnuevos = {};
	private JTable table_1;
	private JTable table_2;
	private CtrlABMCElemento ctrl;
	private JComboBox<String> cmbTipos;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservar window = new Reservar();
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
	public Reservar() {
		initialize();
	}
	
	public Reservar(Persona usuAct) {
		usuarioAct = usuAct;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		reservasCliente = new ArrayList<Elemento>();
		reservas = new ArrayList<Reserva>();
		modelo = new DefaultTableModel(datosnuevos, columnNames);
		tiposElementos = new ArrayList<TipoElemento>();
		elementos = new ArrayList<Elemento>();
		ctrlReserva = new CtrlABMCReserva();
		tipos = new ArrayList<String>();
		ctrlTipoElemento = new CtrlABMCTipoElemento();
		cmbTipos = new JComboBox<String>();
		
		
		
		tiposElementos = ctrlTipoElemento.getAll();
		
//		Date datei =  Date.valueOf("2017-12-30");
//		Date datef = Date.valueOf("2017-12-31");
//		Reserva nuevaR = new Reserva(t1, datei , datef);
//		reservas.add(nuevaR);
		for (TipoElemento tipo : tiposElementos) {
			
			cmbTipos.addItem(tipo.getDescTipo());
		}
		
		
	

		JButton btnComprar = new JButton("RESERVAR");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table_2.getSelectedRowCount()>0){
				String fechaini = null;
				String fechafin = null;
				fechaini = txtFechaInicio.getText();
				fechafin = txtFechaFin.getText();
				Elemento lugarAct = new Elemento();
				Date dateini = null;
				Date datefin = null;
				dateini = Date.valueOf(fechaini);
				datefin = Date.valueOf(fechafin);
//				dateini = obtenerFecha(fechaini);
//				datefin = obtenerFecha(fechafin);
				int indice = table_2.convertColumnIndexToModel(table_2.getSelectedRow());
				TableModel nuevo = table_2.getModel();
				nuevo = table_2.getModel();
				Object id = nuevo.getValueAt(indice, 0);
				
				String seleccionado = id.toString();
				lblResultado.setText(seleccionado);
				Elemento lugar = new Elemento();
				lugarAct.setIdElemento(seleccionado);
				lugar = ctrlElemento.buscarElemento(lugarAct);
				Reserva reservaAct = new Reserva(lugar,dateini,datefin);
				reservaAct.setPersona(usuarioAct);
				lblResultado.setText(fechaini + " " + fechafin + usuarioAct.getNombre() + lugar.getDescripcion());
				if(validarFecha(reservaAct)){
					lblResultado.setText("fecha disponible y reserva realizada");
				}
				else{
					lblResultado.setText("fecha no disponible para "+ lugar.getDescripcion());
					}
				}
			}


			private Date obtenerFecha(String fec) {
				Date fecha = null;
				fecha = Date.valueOf(fec);
			return fecha;
			}
		});

				

		
		JButton btnBuscar = new JButton("Buscar Recintos");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String seleccionado = cmbTipos.getSelectedItem().toString();
			lblResultado.setText(seleccionado);
			actualizarTabla(seleccionado);
			}
			

			private void actualizarTabla(String sel){
			ctrlElemento = new CtrlABMCElemento();
			elementos = ctrlElemento.getAll();
			while(modelo.getRowCount()>0){
			modelo.removeRow(0);
			}
			if(elementos.isEmpty()){
				lblResultado.setText("No hay elementos");
			}
			else{
			for (Elemento elem : elementos) {
					String h1 = "";
					String h2 = "";
					h1 = elem.getTipo().getDescTipo();
					h2 = sel;
					if (h1.equalsIgnoreCase(h2)){
					Object[] newRow= {elem.getIdElemento(),elem.getCapacidad(),elem.getDescripcion(), elem.getUbicacion(), elem.getTipo().getIdTipo()};
					modelo.addRow(newRow);
					}
			}
					table_2.setModel(modelo);
			}
		}});
		
		
		JLabel lblFechaInicio = new JLabel("FechaInicio:");
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		

		
		
		
		lblResultado = new JLabel("---------");
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtFechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(lblFechaInicio))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addComponent(lblResultado)))
							.addGap(25)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(cmbTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(137)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblFechaFin)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuscar)
						.addComponent(cmbTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(lblFechaInicio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(lblFechaFin)
							.addGap(18)
							.addComponent(txtFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblResultado))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
					.addGap(33))
		);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected boolean validarFecha(Reserva reservaAct) {
		Boolean estado = true;
		reservas = ctrlReserva.getAll(reservaAct.getElemento());
		for (Reserva res : reservas) {
				if((res.getFechaInicio().before(reservaAct.getFechaFin()))
						&& (res.getFechaFin().after(reservaAct.getFechaInicio())))
				{
					estado = false;
					return estado;
				}
			}
		return estado;
	}
}
