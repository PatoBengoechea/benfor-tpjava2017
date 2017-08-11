package ui;

import entities.Televisor;

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

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

public class Comprar {

	private JFrame frame;
	String[] columnNames = {"IdProd","Marca","Modelo","Descripcion","Precio",};
	Object[][] datos = {};
	private JFormattedTextField txtPrecio;
	private DefaultTableModel modelo;
	private DefaultTableModel nuevomodelo;
	private JScrollPane scrollLista;
	ArrayList<Televisor> televisores;
	ArrayList<Televisor> carrito;
	private JLabel lblResultado;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comprar window = new Comprar();
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
	public Comprar() {
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
		televisores = new ArrayList<Televisor>();
		carrito = new ArrayList<Televisor>();
		Televisor tele = new Televisor();
		tele.setIdTelevisor(1);
		tele.setMarca("Samsung");
		tele.setModelo("X800");
		tele.setPrecio(2200.50);
		tele.setDescripcion("29 pulgadas");
		Televisor tele1 = new Televisor();
		tele1.setIdTelevisor(2);
		tele1.setMarca("Sony");
		tele1.setModelo("d440");
		tele1.setPrecio(2233.50);
		tele1.setDescripcion("25 pulgadas");
		Televisor tele2 = new Televisor();
		tele2.setIdTelevisor(3);
		tele2.setMarca("LG");
		tele2.setModelo("a790");
		tele2.setPrecio(1503.50);
		tele2.setDescripcion("20 pulgadas");
		Televisor tele3 = new Televisor();
		tele3.setIdTelevisor(4);
		tele3.setMarca("Motorola");
		tele3.setModelo("x940");
		tele3.setPrecio(3003.50);
		tele3.setDescripcion("40 pulgadas");
		televisores.add(tele);
		televisores.add(tele1);
		televisores.add(tele2);
		televisores.add(tele3);
		int tam = televisores.size();
		modelo= new DefaultTableModel(datos,columnNames);
		final JTable table = new JTable(modelo);
		modelo.addRow(columnNames);
		for (Televisor tel : televisores) {
			Object[] newRow= {tel.getIdTelevisor(),tel.getMarca(),tel.getModelo(), tel.getDescripcion(), tel.getPrecio()};
			modelo.addRow(newRow);
		}
		
		

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indice = 0;
				indice = table.getSelectedRow();
				if(indice != 0){
				Televisor teleact = new Televisor();
				teleact = televisores.get(indice-1);
				lblResultado.setText("Compro: " + teleact.getMarca() + " " + teleact.getModelo());
				carrito.add(televisores.get(indice));}
			}
		});

				

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Double valor = Double.parseDouble(txtPrecio.getText());
				double nv = valor.doubleValue(); 
				actualizarListaPrecio(nv);
			}
			private void actualizarListaPrecio(double prec){
				Object[][] datosnuevos = {};
				nuevomodelo = new DefaultTableModel(datosnuevos, columnNames);
				table.setModel(nuevomodelo);
				nuevomodelo.addRow(columnNames);
				for (Televisor tel : televisores) {
					if(tel.getPrecio().doubleValue() < prec ){
						Object[] newRow= {tel.getIdTelevisor(),tel.getMarca(),tel.getModelo(), tel.getDescripcion(), tel.getPrecio()};
						nuevomodelo.addRow(newRow);
					}
				}
			}
		});
		
		
		JLabel lblPrecio = new JLabel("Precio:");
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("#####.##");
			txtPrecio = new JFormattedTextField(mascara);
			txtPrecio.setText("00000.00  ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtPrecio.setColumns(10);
		
		
		
		lblResultado = new JLabel("---------");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrecio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblResultado)
					.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
					.addComponent(btnComprar)
					.addGap(34))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuscar)
						.addComponent(lblPrecio)
						.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnComprar)
						.addComponent(lblResultado))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
