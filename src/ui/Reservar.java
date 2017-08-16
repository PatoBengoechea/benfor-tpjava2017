package ui;

import entities.Elemento;
import entities.TipoElemento;
import entities.Persona;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
	private JTextField txtPrecio;
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
	private JTextField textField;
	
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
		TipoElemento tea = new TipoElemento();
		tiposElementos = new ArrayList<TipoElemento>();
		tipos = new List<String>() {
			
			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<String> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String set(int index, String element) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ListIterator<String> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListIterator<String> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String get(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(int index, Collection<? extends String> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean addAll(Collection<? extends String> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void add(int index, String element) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean add(String e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tipos.add("");
		tea.setIdTipo(0);
		tea.setDescTipo("teatro");
		TipoElemento bar = new TipoElemento("bar");
		TipoElemento est = new TipoElemento("estadio");
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
		modeloLista = new SpinnerListModel();
		modeloLista.setList(tiposElementos);
		
		JSpinner spinner = new JSpinner(modeloLista);
		spinner.setModel(new SpinnerListModel(new String[] {}));
		//spinner.setModel(modeloLista);
	
		
		
		
		
		

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indice = table.getSelectedRow();
				if(table.getSelectedRowCount()>0){
				/*//table.convertColumnIndexToModel(table.getSelectedRow())
				Elemento teleact = new Elemento();
				teleact = televisores.get(indice);
				lblResultado.setText("Compro: " + teleact.getMarca() + " " + teleact.getModelo());
				carrito.add(televisores.get(indice));}*/
				}
			}
		});

				

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				actualizarTabla();
			}
			private void actualizarTabla(){
/*				Object[][] datosnuevos = {};
				tipos = new DefaultTableModel(datosnuevos, columnNames);
				table.setModel(nuevomodelo);
				int tam = televisores.size();
				modelo= new DefaultTableModel(datos,columnNames);
				table = new JTable(modelo);
				for (Elemento tel : televisores) {
					Object[] newRow= {tel.getIdTelevisor(),tel.getMarca(),tel.getModelo(), tel.getDescripcion(), tel.getPrecio()};
					modelo.addRow(newRow);*/
			}
		});
		
		
		JLabel lblFechaInicio = new JLabel("FechaInicio:");
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		
		
		
		lblResultado = new JLabel("---------");
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(27)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblFechaInicio)
												.addComponent(lblFechaFin)))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(32)
											.addComponent(lblResultado))))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFechaInicio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblFechaFin)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblResultado)
							.addGap(42)
							.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		
		//JTable table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
