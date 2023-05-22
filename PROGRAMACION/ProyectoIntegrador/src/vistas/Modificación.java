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

public class Modificación
		extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);	
	
	/**
	 * 
	 */
	public Modificación() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		ImageIcon img=new ImageIcon("D:\\DAW\\Javalearn\\Proyecto2023\\src\\logo.png");
		Image logo=img.getImage().getScaledInstance(40, 40, DO_NOTHING_ON_CLOSE);
		ImageIcon logo1=new ImageIcon(logo);
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
		
		
		JLabel ic = new JLabel("");
		ic.setIcon(logo1);
		menuBar.add(ic);
		
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
		textField.setBounds(213, 87, 153, 27);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setBounds(213, 138, 153, 27);
		panel.add(textField_1);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(116, 85, 66, 29);
		panel.add(label_1_1);
		
		TextField textField_1_1 = new TextField();
		textField_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1.setBounds(213, 190, 153, 27);
		panel.add(textField_1_1);
		
		Label label_1_1_1 = new Label("Curso");
		label_1_1_1.setBounds(133, 136, 49, 29);
		panel.add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("Grupo");
		label_1_1_1_1.setBounds(122, 190, 60, 29);
		panel.add(label_1_1_1_1);
		
		TextField textField_1_1_1 = new TextField();
		textField_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1.setBounds(213, 243, 153, 27);
		panel.add(textField_1_1_1);
		
		TextField textField_1_1_1_1 = new TextField();
		textField_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1.setBounds(213, 289, 153, 27);
		panel.add(textField_1_1_1_1);
		
		Label label_1_1_1_1_1 = new Label("Año");
		label_1_1_1_1_1.setBounds(133, 249, 49, 21);
		panel.add(label_1_1_1_1_1);
		
		Label label_1_1_2 = new Label("Nota");
		label_1_1_2.setBounds(492, 85, 43, 29);
		panel.add(label_1_1_2);
		
		TextField textField_1_1_1_1_1 = new TextField();
		textField_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1_1.setBounds(560, 87, 153, 27);
		panel.add(textField_1_1_1_1_1);
		
		Label label_1_1_2_1 = new Label("ID_Area");
		label_1_1_2_1.setBounds(492, 136, 66, 29);
		panel.add(label_1_1_2_1);
		
		TextField textField_1_1_1_1_1_1 = new TextField();
		textField_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1_1_1.setBounds(560, 138, 153, 27);
		panel.add(textField_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(541, 227, 143, 43);
		panel.add(btnNewButton);
		
		Label label_1_1_1_1_1_1 = new Label("URL");
		label_1_1_1_1_1_1.setBounds(132, 295, 35, 21);
		panel.add(label_1_1_1_1_1_1);
	}
}

