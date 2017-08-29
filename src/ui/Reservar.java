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

public class Reservar {

	private JFrame frame;
	Object[][] datos = {};
	private JTextField txtFechaInicio;
	private DefaultTableModel modelo;
	private DefaultTableModel nuevomodelo;
	private JScrollPane scrollLista;
	private SpinnerListModel modeloLista;
	public ArrayList<Elemento> elementos;
	public ArrayList<Elemento> reservasCliente;
	public ArrayList<Reserva> reservas;
	public ArrayList<TipoElemento> tiposElementos;
	public List<String> tipos;
	private JLabel lblResultado;
	private JTable table;
	private JTextField txtFechaFin;
	Object[] columnNames = {"Id", "Capacidad", "Descripcion", "Ubicacion"};
	String[][] datosnuevos = {};
	private JTable table_1;
	private JTable table_2;
	
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
		tipos = new ArrayList<String>();
		//carga de datos array list momentaneos
		TipoElemento tea = new TipoElemento();
		tea.setIdTipo(0);
		tea.setDescTipo("teatro");
		tea.setCantdiasMax(4);
		TipoElemento bar = new TipoElemento();
		
		elementos = new ArrayList<Elemento>();
		bar.setIdTipo(1);
		bar.setDescTipo("bar");
		bar.setCantdiasMax(4);
		TipoElemento est = new TipoElemento();
		est.setIdTipo(2);
		est.setDescTipo("estadio");
		est.setCantdiasMax(6);
		tiposElementos.add(tea);
		tiposElementos.add(bar);
		tiposElementos.add(est);
		Elemento t1 = new Elemento("Teatro Gran Rex",2000,"Mitre 200",tea);
		Elemento t2 = new Elemento("Teatro Opera",3000,"Mitre 900",tea);
		Elemento b1 = new Elemento("Paso Sport",200,"Paraguay 1300",bar);
		Elemento b2 = new Elemento("Fellini",150,"Corrientes 1400",bar);
		Elemento e1 = new Elemento("Estadio Marcelo Bielsa",5000,"27 de Febrero 2400",est);
		Elemento e2 = new Elemento("Estadio Gigante de Arroyito",4000,"Costanera 800",est);
		elementos.add(t1);
		elementos.add(t2);
		elementos.add(b1);
		elementos.add(b2);
		elementos.add(e1);
		elementos.add(e2);
		Date datei = new Date(2017,12,30);
		Date datef = new Date(2017,12,31);
		Reserva nuevaR = new Reserva(t1, datei , datef);
		reservas.add(nuevaR);
		for (TipoElemento tipo : tiposElementos) {
			tipos.add(tipo.getDescTipo());
		}
		//Termina la carga
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(tipos));
	

		JButton btnComprar = new JButton("RESERVAR");
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
				dateini = obtenerFecha(fechaini);
				datefin = obtenerFecha(fechafin);
				int indice = table_2.convertColumnIndexToModel(table_2.getSelectedRow());
				TableModel nuevo = table_2.getModel();
				nuevo = table_2.getModel();
				Object id = nuevo.getValueAt(indice, 0);
				String seleccionado = id.toString();
				lblResultado.setText(seleccionado);
				Reserva reservaAct = new Reserva(lugarAct,dateini,datefin);
				if(validarFecha(reservaAct)){
					lblResultado.setText("fecha disponible y reserva realizada");
				};
				}
			}


			private Date obtenerFecha(String fec) {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
				fecha = formatoDelTexto.parse(fec);
				} catch (ParseException ex) {
				ex.printStackTrace();
				}
			return fecha;
			}
		});

				

		
		JButton btnBuscar = new JButton("Buscar Recintos");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			buscar();
			String seleccionado = spinner.getValue().toString();
			lblResultado.setText(seleccionado);
			actualizarTabla(seleccionado);
			}
			
			private void actualizarTabla(String sel){
			while(modelo.getRowCount()>0){
			modelo.removeRow(0);
			}
			for (Elemento elem : elementos) {
					if (elem.getTipo().getDescTipo().equals(sel)){
					Object[] newRow= {elem.getIdElemento(),elem.getCapacidad(),elem.getDescripcion(), elem.getUbicacion()};
					modelo.addRow(newRow);
					}}
					table_2.setModel(modelo);
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
									.addComponent(lblFechaInicio)))
							.addGap(25)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblResultado))
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
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblResultado)
							.addGap(32)
							.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
					.addGap(46))
		);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected boolean validarFecha(Reserva reservaAct) {
		Boolean estado = true;
		for (Reserva res : reservas) {
			if(reservaAct.getElemento().equals(res.getElemento())){
				if((res.getFechaInicio().before(reservaAct.getFechaFin()))
						|| (res.getFechaFin().after(reservaAct.getFechaInicio())))
				{
					estado = false;
					return estado;
				}
			
			}
		}
		return estado;
	}

	protected void buscar() {
		// TODO Auto-generated method stub
		
	}
}
