package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowUser extends JFrame {
	

	private JFrame frame;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowUser frame = new MainWindowUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindowUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAbmcPersona = new JButton("ABMC PERSONA");
		btnAbmcPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				abrirABMCPERSONA();
			}
		});
		
		JButton btnReservas = new JButton("Agregar Reserva");
		btnReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirReserbas();
			}
		});
		
		JButton btnNewButton = new JButton("Agregar Tipo Recinto");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTipoRecinto();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Agregar Recinto");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirRecinto();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAbmcPersona, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(btnReservas, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(btnAbmcPersona)
					.addGap(18)
					.addComponent(btnReservas)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void abrirRecinto() {
		MainWindowUser vc = new MainWindowUser();
		GestionRecintos reser = new GestionRecintos();
		reser.main(null);
		vc.setVisible(false);
		
	}

	protected void abrirTipoRecinto() {
		MainWindowUser vc = new MainWindowUser();
		GestionTipos reser = new GestionTipos();
		reser.main(null);
		vc.setVisible(false);
	}

	protected void abrirReserbas() {
		MainWindowUser vc = new MainWindowUser();
		Reservar reser = new Reservar();
		reser.main(null);
		vc.setVisible(false);
	}

	protected void abrirABMCPERSONA() {
		MainWindowUser vc = new MainWindowUser();
		ABMCPersonaDesktop abmP = new ABMCPersonaDesktop();
		abmP.main(null);
		vc.setVisible(false);
	}
}
