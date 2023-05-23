package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.MenuListener;
import controlador.altaAlumnoButton;

import java.awt.*;

/*
 * Clase de la ventana de añadir alumno
 */
public class AltaAlumno extends JFrame {
	// Variables
	private JPanel contentPane;
	// Creación de la variable del MenuListener
	private MenuListener menuListener = new MenuListener(this);		
	private TextField nombreTxt;
	private TextField apellidoTxt;
	private TextField nExpendienteTxt;
	private TextField idProyectoTxt;

	public AltaAlumno() {
		// Establecemos que cuando se cierre la pestaña se acabe el programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ajustamos el tamaño de la ventana
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		// MENÚ //

		// ICONO

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		ImageIcon logo = new ImageIcon("proyecto-integrador/PROGRAMACION/ProyectoIntegrador/img/logo.png");
		Image originalImage = logo.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JMenuItem item = new JMenuItem(resizedIcon);
		item.setRolloverEnabled(false);
		
		item.setIcon(resizedIcon);
		menuBar.add(item);

		//PI
		JMenu PI = new JMenu("P.I.");
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		Añadir.addActionListener(menuListener);

		//Area
		JMenu Area = new JMenu("Área");
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
		
		nombreTxt  = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(434, 85, 153, 27);
		panel.add(nombreTxt);
		
		apellidoTxt= new TextField();
		apellidoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		apellidoTxt.setBounds(434, 136, 153, 27);
		panel.add(apellidoTxt);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(318, 83, 66, 29);
		panel.add(label_1_1);
		
		nExpendienteTxt= new TextField();
		nExpendienteTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nExpendienteTxt.setBounds(434, 192, 153, 27);
		panel.add(nExpendienteTxt);
		
		Label label_1_1_1 = new Label("Apellidos");
		label_1_1_1.setBounds(314, 136, 66, 29);
		panel.add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("Nº Expendiente");
		label_1_1_1_1.setBounds(261, 190, 117, 29);
		panel.add(label_1_1_1_1);
		
		idProyectoTxt = new TextField();
		idProyectoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		idProyectoTxt.setBounds(434, 243, 153, 27);
		panel.add(idProyectoTxt);
		
		Label label_1_1_1_1_1 = new Label("ID_Proyecto ");
		label_1_1_1_1_1.setBounds(282, 241, 102, 29);
		panel.add(label_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(367, 363, 143, 43);
		//-----------------------
		altaAlumnoButton altaAbtn=new altaAlumnoButton(this);
		btnNewButton.addActionListener(altaAbtn);
		panel.add(btnNewButton);
	}
	//-----------------------
	public String getNombre() {
		return nombreTxt.getText();
	}

	public String getApellido() {
		return apellidoTxt.getText();
	}

	public String getNExpendiente() {
		return nExpendienteTxt.getText();
	}

	public String getIdProyecto() {
		return idProyectoTxt.getText();
	}
}


