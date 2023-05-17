package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.MenuListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Add_Alumno extends JFrame {
	// Variables
	private JPanel contentPane;
	// Creación de la variable del MenuListener
	private MenuListener menuListener = new MenuListener(this);		
	
	public Add_Alumno() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
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
		menuBar.setForeground(new Color(3, 8, 62));
		menuBar.setBackground(new Color(3, 8, 62));
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
		
		Label label_1_1_1 = new Label("Apellidos");
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
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(367, 363, 143, 43);
		panel.add(btnNewButton);
	}
}


