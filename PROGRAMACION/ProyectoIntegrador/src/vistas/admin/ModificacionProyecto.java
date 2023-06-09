package vistas.admin;

import java.awt.Image;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

import controlador.admin.MenuListener;
import controlador.admin.modificarProyecto;

import javax.swing.JButton;

/**
 * La clase ModificacionProyecto crea el marco de la ventana y configura sus
 * propiedades.
 */
public class ModificacionProyecto extends JFrame {
	private int idProyecto;
	private TextField nombreTxt, cursoTxt, grupoTxt, yearTxt, urlTxt, notaTxt, areaTxt;
	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);

	/**
	 * Crea la ventana de ModificacionProyecto.
	 * 
	 * @param id el ID del proyecto a modificar.
	 */
	public ModificacionProyecto(int id) {
		this.idProyecto = id;
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

		// Creamos el content pane
		JPanel panel = new JPanel();
		panel.setBounds(10, 86, 939, 524);
		contentPane.add(panel);
		panel.setLayout(null);

		// Text fields y labels

		Label labelNombre = new Label("Nombre");
		labelNombre.setBounds(116, 85, 66, 29);
		panel.add(labelNombre);

		nombreTxt = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(213, 87, 153, 27);
		panel.add(nombreTxt);

		Label labelCurso = new Label("Curso");
		labelCurso.setBounds(133, 136, 49, 29);
		panel.add(labelCurso);

		cursoTxt = new TextField();
		cursoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		cursoTxt.setBounds(213, 138, 153, 27);
		panel.add(cursoTxt);

		Label labelGrupo = new Label("Grupo");
		labelGrupo.setBounds(122, 190, 60, 29);
		panel.add(labelGrupo);

		grupoTxt = new TextField();
		grupoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		grupoTxt.setBounds(213, 190, 153, 27);
		panel.add(grupoTxt);

		Label labelYear = new Label("Año");
		labelYear.setBounds(133, 249, 49, 21);
		panel.add(labelYear);

		yearTxt = new TextField();
		yearTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		yearTxt.setBounds(213, 243, 153, 27);
		panel.add(yearTxt);

		Label labelUrl = new Label("URL");
		labelUrl.setBounds(132, 295, 35, 21);
		panel.add(labelUrl);

		urlTxt = new TextField();
		urlTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		urlTxt.setBounds(213, 289, 153, 27);
		panel.add(urlTxt);

		Label labelNota = new Label("Nota");
		labelNota.setBounds(492, 85, 43, 29);
		panel.add(labelNota);

		notaTxt = new TextField();
		notaTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		notaTxt.setBounds(560, 87, 153, 27);
		panel.add(notaTxt);

		Label labelArea = new Label("ID_Area");
		labelArea.setBounds(492, 136, 66, 29);
		panel.add(labelArea);

		areaTxt = new TextField();
		areaTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		areaTxt.setBounds(560, 138, 153, 27);
		panel.add(areaTxt);

		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(541, 227, 143, 43);
		panel.add(btnNewButton);

		modificarProyecto modificarBtn = new modificarProyecto(this, idProyecto);
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
	 * Obtiene el curso ingresado.
	 * 
	 * @return el curso ingresado.
	 */
	public String getCurso() {
		return cursoTxt.getText();
	}

	/**
	 * Obtiene el grupo ingresado.
	 * 
	 * @return el grupo ingresado.
	 */
	public String getGrupo() {
		return grupoTxt.getText();
	}

	/**
	 * Obtiene el año ingresado.
	 * 
	 * @return el año ingresado.
	 */
	public String getYear() {
		return yearTxt.getText();
	}

	/**
	 * Obtiene la URL ingresada.
	 * 
	 * @return la URL ingresada.
	 */
	public String getUrl() {
		return urlTxt.getText();
	}

	/**
	 * Obtiene la nota ingresada.
	 * 
	 * @return la nota ingresada.
	 */
	public String getNota() {
		return notaTxt.getText();
	}

	/**
	 * Obtiene el área ingresada.
	 * 
	 * @return el área ingresada.
	 */
	public String getArea() {
		return areaTxt.getText();
	}

}
