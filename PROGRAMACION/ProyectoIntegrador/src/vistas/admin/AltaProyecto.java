package vistas.admin;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.admin.MenuListener;
import controlador.admin.altaProyectoButton;
import modelo.Proyecto;

/**
 * La clase `AltaProyecto` representa una ventana JFrame para agregar un nuevo
 * proyecto.
 * Esta clase extiende la clase `JFrame` e implementa la funcionalidad para
 * agregar los detalles del proyecto.
 */
public class AltaProyecto extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);

	private TextField nombreTxt;
	private TextField cursoTxt;
	private TextField grupoTxt;
	private TextField yearTxt;
	private TextField linkTxt;
	private TextField notaTxt;
	private TextField areaTxt;
	private Label error;

	/**
	 * Crea la ventana.
	 */
	public AltaProyecto() {
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
		menuBar.setBackground(new Color(3, 8, 62));
		setJMenuBar(menuBar);

		ImageIcon logo = new ImageIcon("proyecto-integrador/PROGRAMACION/ProyectoIntegrador/img/logo.png");
		Image originalImage = logo.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JMenuItem item = new JMenuItem(resizedIcon);
		item.setForeground(new Color(3, 8, 62));
		item.setRolloverEnabled(false);
		item.setBackground(new Color(3, 8, 62));

		item.setIcon(resizedIcon);
		menuBar.add(item);

		// PI
		JMenu PI = new JMenu("P.I.");
		PI.setForeground(new Color(255, 255, 255));
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);

		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		// Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		Alumnos.setForeground(new Color(255, 255, 255));
		menuBar.add(Alumnos);

		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);

		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);

		Añadir.addActionListener(menuListener);

		// Area
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
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 939, 524);
		contentPane.add(panel);
		panel.setLayout(null);

		nombreTxt = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(434, 85, 153, 27);
		panel.add(nombreTxt);

		cursoTxt = new TextField();
		cursoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		cursoTxt.setBounds(434, 136, 153, 27);
		panel.add(cursoTxt);

		Label label_1_1 = new Label("Nombre");
		label_1_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_1_1.setBounds(318, 85, 66, 29);
		panel.add(label_1_1);

		grupoTxt = new TextField();
		grupoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		grupoTxt.setBounds(434, 192, 153, 27);
		panel.add(grupoTxt);

		Label label_1_1_1 = new Label("Curso");
		label_1_1_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_1_1_1.setBounds(335, 134, 49, 29);
		panel.add(label_1_1_1);

		yearTxt = new TextField();
		yearTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		yearTxt.setBounds(434, 243, 153, 27);
		panel.add(yearTxt);

		Label label_1_1_1_1_1 = new Label("Año");
		label_1_1_1_1_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_1_1_1_1_1.setBounds(341, 243, 43, 29);
		panel.add(label_1_1_1_1_1);

		linkTxt = new TextField();
		linkTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		linkTxt.setBounds(434, 293, 153, 27);
		panel.add(linkTxt);

		notaTxt = new TextField();
		notaTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		notaTxt.setBounds(434, 347, 153, 27);
		panel.add(notaTxt);

		areaTxt = new TextField();
		areaTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		areaTxt.setBounds(434, 401, 153, 27);
		panel.add(areaTxt);

		Label label_area = new Label("ID_Área");
		label_area.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_area.setBounds(341, 401, 43, 29);
		panel.add(label_area);

		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(3, 8, 62));
		btnNewButton.setBounds(386, 456, 143, 43);

		// btn para insertar los datos al BD.
		altaProyectoButton altaPBtn = new altaProyectoButton(this);
		btnNewButton.addActionListener(altaPBtn);
		panel.add(btnNewButton);

		Label label_1_1_1_1 = new Label("Grupo");
		label_1_1_1_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_1_1_1_1.setBounds(335, 190, 49, 29);
		panel.add(label_1_1_1_1);

		Label label_1_1_1_1_1_1 = new Label("URL");
		label_1_1_1_1_1_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_1_1_1_1_1_1.setBounds(341, 293, 43, 29);
		panel.add(label_1_1_1_1_1_1);

		Label label_1_1_1_1_1_1_1 = new Label("Nota");
		label_1_1_1_1_1_1_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		label_1_1_1_1_1_1_1.setBounds(341, 345, 43, 29);
		panel.add(label_1_1_1_1_1_1_1);

		//--------------
		error = new Label("");
		error.setBounds(330, 500, 330, 30);
		error.setForeground(new Color(255, 0 , 0));
		panel.add(error);
	}

	/**
	 * Obtiene el nombre del proyecto ingresado.
	 * 
	 * @return el nombre del proyecto.
	 */
	public Proyecto getProyecto() {
		String nombre = nombreTxt.getText();
		String curso = cursoTxt.getText();
		String grupo = grupoTxt.getText();
		int year = 0;
		String link = linkTxt.getText();
		int nota = 0;
		int area = 0;
	
		// Validación del campo year
		String yearStr = yearTxt.getText();
		if (!yearStr.isEmpty()) {
			try {
				year = Integer.parseInt(yearStr);
			} catch (NumberFormatException e) {
				year = 0;
				error.setText("El campo Year debe ser un número válido");
				return null;  // Retorna null si hay un error de validación
			}
		}
	
		// Validación del campo nota
		String notaStr = notaTxt.getText();
		if (!notaStr.isEmpty()) {
			try {
				nota = Integer.parseInt(notaStr);
			} catch (NumberFormatException e) {
				nota = 0;
				error.setText("El campo Nota debe ser un número válido");
				return null;  // Retorna null si hay un error de validación
			}
		}
	
		// Validación del campo area
		String areaStr = areaTxt.getText();
		if (!areaStr.isEmpty()) {
			try {
				area = Integer.parseInt(areaStr);
			} catch (NumberFormatException e) {
				area = 0;
				error.setText("El campo Area debe ser un número válido");
				return null;  // Retorna null si hay un error de validación
			}
		}
	
		Proyecto p = new Proyecto(nombre, curso, grupo, year, link, nota, area);
		error.setText("");
		return p;
	}
	
}
