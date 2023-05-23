package vistas.admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controlador.admin.MenuListener;
import controlador.admin.altaAlumnoButton;
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
	private TextField nExpedienteTxt;
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
		menuBar.setBackground(new Color(3, 8, 62));

		ImageIcon logo = new ImageIcon("proyecto-integrador/PROGRAMACION/ProyectoIntegrador/img/logo.png");
		Image originalImage = logo.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JMenuItem item = new JMenuItem(resizedIcon);
		item.setRolloverEnabled(false);
		item.setBackground(new Color(3, 8, 62));
		
		item.setIcon(resizedIcon);
		menuBar.add(item);

		//PI
		JMenu PI = new JMenu("P.I.");
		PI.setForeground(new Color(255, 255, 255));
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		Alumnos.setForeground(new Color(255, 255, 255));
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		Añadir.addActionListener(menuListener);

		//Area
		JMenu Area = new JMenu("Área");
		Area.setForeground(new Color(255, 255, 255));
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
		panel.setBounds(10, 52, 939, 524);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label labelNombre = new Label("Nombre");
		labelNombre.setBounds(318, 83, 66, 29);
		panel.add(labelNombre);

		nombreTxt  = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(434, 85, 153, 27);
		panel.add(nombreTxt);
		
		Label labelApellidos = new Label("Apellidos");
		labelApellidos.setBounds(314, 136, 66, 29);
		panel.add(labelApellidos);

		apellidoTxt= new TextField();
		apellidoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		apellidoTxt.setBounds(434, 136, 153, 27);
		panel.add(apellidoTxt);
		
		Label labelExpediente = new Label("Nº Expendiente");
		labelExpediente.setBounds(261, 190, 117, 29);
		panel.add(labelExpediente);
		
		nExpedienteTxt= new TextField();
		nExpedienteTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nExpedienteTxt.setBounds(434, 192, 153, 27);
		panel.add(nExpedienteTxt);
		
		Label labelProyecto = new Label("ID_Proyecto ");
		labelProyecto.setBounds(282, 241, 102, 29);
		panel.add(labelProyecto);
		
		idProyectoTxt = new TextField();
		idProyectoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		idProyectoTxt.setBounds(434, 243, 153, 27);
		panel.add(idProyectoTxt);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(3, 8, 62));
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

	public String getNExpediente() {
		return nExpedienteTxt.getText();
	}

	public String getIdProyecto() {
		return idProyectoTxt.getText();
	}
}


