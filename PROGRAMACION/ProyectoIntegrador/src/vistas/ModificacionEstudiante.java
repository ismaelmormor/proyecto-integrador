package vistas;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.MenuListener;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificacionEstudiante
		extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);	


	/**
	 * Create the frame.
	 */
	public ModificacionEstudiante() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(
				new EmptyBorder(5, 5, 5,
						5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar);
		menuBar.setForeground(new Color(142, 124, 195));
		menuBar.setBackground(new Color(142, 124, 195));
		menuBar.setBounds(0, 0, 959, 59);
		
		
		ImageIcon logo = new ImageIcon("C:\\Users\\santi\\Downloads\\logo.png");
		Image originalImage = logo.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JMenuItem item = new JMenuItem(resizedIcon);
		item.setRolloverEnabled(false);
		item.setForeground(new Color(3, 8, 62));
		item.setBackground(new Color(3, 8, 62));
		item.setIcon(resizedIcon);
		menuBar.add(item);
		
		//PI
		JMenu PI = new JMenu("P.I.");
		PI.setForeground(Color.white);
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		Alumnos.setForeground(Color.white);
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		Añadir.addActionListener(menuListener);

		//Area
		JMenu Area = new JMenu("Área");
		Area.setForeground(Color.white);
		menuBar.add(Area);
		
		JMenuItem Daw = new JMenuItem("DAW");
		Area.add(Daw);

		Daw.addActionListener(menuListener);
		
		JMenuItem Dam = new JMenuItem("DAM");
		Area.add(Dam);
		
		Dam.addActionListener(menuListener);

		JMenuItem Asir = new JMenuItem("ASIR");
		Area.add(Asir);

		Asir.addActionListener(menuListener);
		
		JMenuItem Animacion = new JMenuItem("ANIMACIONES 3D");
		Area.add(Animacion);

		Animacion.addActionListener(menuListener);
		
		JMenuItem Juegos = new JMenuItem("VIDEOJUEGOS");
		Area.add(Juegos);

		Juegos.addActionListener(menuListener);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 86, 939, 524);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TextField textField = new TextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField.setBounds(434, 85, 153, 27);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setBounds(434, 136, 153, 27);
		panel.add(textField_1);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(318, 83, 66, 29);
		panel.add(label_1_1);
		
		TextField textField_1_1 = new TextField();
		textField_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1.setBounds(434, 192, 153, 27);
		panel.add(textField_1_1);
		
		Label label_1_1_1 = new Label("Apeilldos");
		label_1_1_1.setBounds(314, 136, 66, 29);
		panel.add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("Nº Expendiente");
		label_1_1_1_1.setBounds(261, 190, 117, 29);
		panel.add(label_1_1_1_1);
		
		TextField textField_1_1_1 = new TextField();
		textField_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1.setBounds(434, 243, 153, 27);
		panel.add(textField_1_1_1);
		
		Label label_1_1_1_1_1 = new Label("ID_Proyecto ");
		label_1_1_1_1_1.setBounds(282, 241, 102, 29);
		panel.add(label_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(367, 363, 143, 43);
		panel.add(btnNewButton);
	}
}

