package vistas.admin;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;

import controlador.admin.MenuListener;
import controlador.admin.modificarAlumno;

import javax.swing.JButton;

/**
 * La clase ModificacionEstudiante crea el marco de la ventana y configura sus
 * propiedades.
 */
public class ModificacionEstudiante extends JFrame {
	private int idAlumno;
	private JPanel contentPane;
	private TextField nombreTxt, apellidosTxt, expedienteTxt, proyectoTxt;
	private MenuListener menuListener = new MenuListener(this);

	/**
	 * Crea la ventana de ModificacionEstudiante.
	 * 
	 * @param id el ID del alumno a modificar.
	 */
	public ModificacionEstudiante(int id) {
		this.idAlumno = id;

		// Establecemos que cuando se cierre la pestaña se acabe el programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ajustamos el tamaño de la ventana
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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

		// PI
		JMenu PI = new JMenu("P.I.");
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);

		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		// Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);

		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);

		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);

		Añadir.addActionListener(menuListener);

		// Area
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

		// Labels y textFields
		// Nombre
		Label labelNombre = new Label("Nombre");
		labelNombre.setBounds(318, 83, 66, 29);
		panel.add(labelNombre);

		nombreTxt = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(434, 85, 153, 27);
		panel.add(nombreTxt);
		// Apellidos
		Label labelApellidos = new Label("Apellidos");
		labelApellidos.setBounds(314, 136, 66, 29);
		panel.add(labelApellidos);

		apellidosTxt = new TextField();
		apellidosTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		apellidosTxt.setBounds(434, 136, 153, 27);
		panel.add(apellidosTxt);
		// Nº Expediente
		Label labelExpediente = new Label("Nº Expendiente");
		labelExpediente.setBounds(261, 190, 117, 29);
		panel.add(labelExpediente);

		expedienteTxt = new TextField();
		expedienteTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		expedienteTxt.setBounds(434, 192, 153, 27);
		panel.add(expedienteTxt);

		// Id proyecto
		Label labelProyecto = new Label("ID_Proyecto");
		labelProyecto.setBounds(261, 242, 117, 29);
		panel.add(labelProyecto);

		proyectoTxt = new TextField();
		proyectoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		proyectoTxt.setBounds(434, 244, 153, 27);
		panel.add(proyectoTxt);

		// Botón para modificar

		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(367, 363, 143, 43);

		modificarAlumno modificarBtn = new modificarAlumno(this, idAlumno);
		btnNewButton.addActionListener(modificarBtn);
		panel.add(btnNewButton);

	}

	/**
	 * Obtiene el nombre ingresado.
	 * 
	 * @return el nombre ingresado.
	 */
	public String getNombre() {
		return nombreTxt.getText();
	}

	/**
	 * Obtiene los apellidos ingresados.
	 * 
	 * @return los apellidos ingresados.
	 */
	public String getApellidos() {
		return apellidosTxt.getText();
	}

	/**
	 * Obtiene el número de expediente ingresado.
	 * 
	 * @return el número de expediente ingresado.
	 */	
	public String getExpediente() {
		return expedienteTxt.getText();
	}

	/**
	 * Obtiene el ID del proyecto ingresado.
	 * 
	 * @return el ID del proyecto ingresado.
	 */
	public String getIdProyecto() {
		return proyectoTxt.getText();
	}
}
