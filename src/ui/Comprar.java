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

public class Comprar {

	private JFrame frame;
	private JFormattedTextField txtPrecio;
	private JList list;
	private DefaultListModel modelo;
	private DefaultListModel nuevomodelo;
	private JScrollPane scrollLista;
	private String[] datos;
	ArrayList<Televisor> televisores;
	ArrayList<Televisor> carrito;
	private JLabel lblResultado;
	
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
		datos = new String[televisores.size()];
		for (Televisor tel : televisores) {
			String datostele ="     " + tel.getMarca() + "   ---   " + tel.getModelo() + "   ---   " + tel.getSPrecio()+ "   ---   " + tel.getDescripcion() + "   ---   ";
			datos[televisores.indexOf(tel)] = datostele;
		}
		list = new JList(datos);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indice = 0;
				indice = list.getSelectedIndex();
				if(indice != 0){
				Televisor teleact = new Televisor();
				teleact = televisores.get(indice);
				lblResultado.setText("Compro: " + teleact.getMarca() + " " + teleact.getModelo());
				carrito.add(televisores.get(indice));}
			}
		});

				

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Double valor = Double.parseDouble(txtPrecio.getText());
				//if(valor = 7){
				double nv = valor.doubleValue(); 
				actualizarListaPrecio(nv);
			}

			private void actualizarListaPrecio(double prec) {
				nuevomodelo = new DefaultListModel();
				for (Televisor tel : televisores) {
					if(tel.getPrecio().doubleValue() > prec )
						nuevomodelo.addElement("     " + tel.getMarca() + "   ---   " + tel.getModelo() + "   ---   " + tel.getSPrecio()+ "   ---   " + tel.getDescripcion() + "   ---   ");
				}
				if(nuevomodelo.isEmpty()){
					nuevomodelo.addElement("No hay televisores menores a dicho precio");
				}
				list.setModel(nuevomodelo);
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
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrecio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblResultado)
					.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addComponent(btnComprar)
					.addGap(34))
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
					.addGap(18)
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
