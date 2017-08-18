package ui;

import entities.Elemento;
import entities.TipoElemento;
import entities.Persona;
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

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSpinner;

public class Reservar {

	private JFrame frame;
	Object[][] datos = {};
	private JTextField txtFechaInicio;
	private DefaultTableModel modelo;
	private DefaultTableModel nuevomodelo;
	private JScrollPane scrollLista;
	private SpinnerListModel modeloLista;
	public ArrayList<Elemento> teatros;
	public ArrayList<Elemento> bares;
	public ArrayList<Elemento> estadios;
	public ArrayList<Elemento> reservasCliente;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teatros = new ArrayList<Elemento>();
		bares = new ArrayList<Elemento>();
		estadios = new ArrayList<Elemento>();
		reservasCliente = new ArrayList<Elemento>();
		modelo = new DefaultTableModel(datosnuevos, columnNames);
		tiposElementos = new ArrayList<TipoElemento>();
		tipos = new ArrayList<String>();
		
		TipoElemento tea = new TipoElemento();
		tea.setIdTipo(0);
		tea.setDescTipo("teatro");
		TipoElemento bar = new TipoElemento();
		bar.setIdTipo(1);
		bar.setDescTipo("bar");
		TipoElemento est = new TipoElemento();
		est.setIdTipo(2);
		est.setDescTipo("estadio");
		tiposElementos.add(tea);
		tiposElementos.add(bar);
		tiposElementos.add(est);
		Elemento t1 = new Elemento("Teatro Gran Rex",2000,"Mitre 200",tea);
		Elemento t2 = new Elemento("Teatro Opera",3000,"Mitre 900",tea);
		Elemento b1 = new Elemento("Paso Sport",200,"Paraguay 1300",bar);
		Elemento b2 = new Elemento("Fellini",150,"Corrientes 1400",bar);
		Elemento e1 = new Elemento("Estadio Marcelo Bielsa",5000,"27 de Febrero 2400",est);
		Elemento e2 = new Elemento("Estadio Gigante de Arroyito",4000,"Costanera 800",est);
		teatros.add(t1);
		teatros.add(t2);
		bares.add(b1);
		bares.add(b2);
		estadios.add(e1);
		estadios.add(e2);
		for (TipoElemento tipo : tiposElementos) {
			tipos.add(tipo.getDescTipo());
		}
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(tipos));
	
		
		
		
		
		

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRowCount()>0){
				int indice = table.convertColumnIndexToModel(table.getSelectedRow());
				Elemento lugarAct = new Elemento();
				TableModel nuevo = table.getModel();
				Object id = nuevo.getValueAt(indice, 0);
				String seleccionado = id.toString();
				lblResultado.setText(seleccionado);
				//lugarAct = bares.get(indice);
				//lblResultado.setText("Reservo: " + lugarAct.getDescripcion() + " " + lugarAct.getUbicacion());
				//carrito.add(televisores.get(indice));}
				}
			}
		});

				

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String seleccionado = spinner.getValue().toString();
			lblResultado.setText(seleccionado);
			
			actualizarTabla(seleccionado);
			}
			
			private void actualizarTabla(String sel){
			while(modelo.getRowCount()>0){
			modelo.removeRow(0);
			}
				if(sel.equals("bar")){
					for (Elemento el : bares) {
					Object[] newRow= {el.getIdElemento(),el.getCapacidad(),el.getDescripcion(), el.getUbicacion()};
					modelo.addRow(newRow);
					}
					table_2.setModel(modelo);
			}
				if(sel.equals("estadio")){
					for (Elemento el : estadios) {
					Object[] newRow= {el.getIdElemento(),el.getCapacidad(),el.getDescripcion(), el.getUbicacion()};
					modelo.addRow(newRow);
					}
					table_2.setModel(modelo);
			}
				if(sel.equals("teatro")){
					for (Elemento el : teatros) {
					Object[] newRow= {el.getIdElemento(),el.getCapacidad(),el.getDescripcion(), el.getUbicacion()};
					modelo.addRow(newRow);
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(13)
									.addComponent(lblFechaInicio))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtFechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(23)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar)))
					.addGap(20))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(488, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblResultado)
					.addContainerGap(515, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(479, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblFechaFin)
					.addContainerGap(505, Short.MAX_VALUE))
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
}
