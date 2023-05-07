package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Add_Alumno
		extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(
			String[] args) {
		EventQueue.invokeLater(
				new Runnable() {
					public void run() {
						try {
							Add_Alumno frame = new Add_Alumno();
							frame.setVisible(
									true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
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
		menuBar.setForeground(new Color(142, 124, 195));
		menuBar.setBackground(new Color(142, 124, 195));
		menuBar.setBounds(0, 0, 959, 59);
		
		
		JLabel ic = new JLabel("");
		ic.setIcon(logo1);
		menuBar.add(ic);
		
		//PI
		JMenu PI = new JMenu("P.I.");
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(new ActionListener() { //action listener que abre consulta 
		    public void actionPerformed(ActionEvent e) {
				dispose();
		        ConsultaW ventanaConsulta = new ConsultaW();
		        ventanaConsulta.setVisible(true);
		      
		    }
		});

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(new ActionListener() { //action listener que abre alta
		    public void actionPerformed(ActionEvent e) {
		        Alta ventanaAlta = new Alta();
		        ventanaAlta.setVisible(true);
		      
		    }
		});

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        ListaDeAlumnos ventanaLista = new ListaDeAlumnos();
		        ventanaLista.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		Añadir.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Add_Alumno ventanaAdd_Alumno = new Add_Alumno();
		        ventanaAdd_Alumno.setVisible(true);
				
		      
		    }
		});

		//Area
		JMenu Area = new JMenu("Área");
		menuBar.add(Area);
		
		JMenuItem Daw = new JMenuItem("DAW");
		Area.add(Daw);

		Daw.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        DAW ventanaDAW = new DAW();
		        ventanaDAW.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Dam = new JMenuItem("DAM");
		Area.add(Dam);
		
		Dam.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        DAM ventanaDAM = new DAM();
		        ventanaDAM.setVisible(true);
				
		      
		    }
		});

		JMenuItem Asir = new JMenuItem("ASIR");
		Area.add(Asir);

		Asir.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Asir ventanaAsir = new Asir();
		        ventanaAsir.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Animacion = new JMenuItem("ANIMACIONES 3D");
		Area.add(Animacion);

		Animacion.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Animacion3D ventanaAnim = new Animacion3D();
		        ventanaAnim.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Juegos = new JMenuItem("VIDEOJUEGOS");
		Area.add(Juegos);

		Juegos.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Juegos ventanaJuegos = new Juegos();
		        ventanaJuegos.setVisible(true);
				
		      
		    }
		});
		
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


