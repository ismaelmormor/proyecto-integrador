package vistas.admin;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controlador.admin.*;
import modelo.*;

/**
 * ListaVAlumnos
 * Crea el frame de la ventana y configura sus propiedades.
 */
public class ListaDeAlumnos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private MenuListener menuListener = new MenuListener(this);	
	private ArrayList<Alumno> listaAlumnos;

	private TextField nExpedienteTxt, nombreTxt, apellidoTxt, IDProyectoTxt;
	 
	/**
	 * Crea la ventana de ListaDeAlumnos.
	 */
	public ListaDeAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5,5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		menuBar.add(PI);
		PI.setForeground(new Color(255, 255, 255));

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		Alumnos.setForeground(new Color(255, 255, 255));

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
		panel.setBounds(10, 10, 939, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nExpedienteTxt = new TextField();
		nExpedienteTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nExpedienteTxt.setBounds(178, 45, 153, 27);
		panel.add(nExpedienteTxt);
		
		Label label = new Label("Filtros");
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setBounds(35, 10, 142, 62);
		panel.add(label);
		
		Label labelExpediente = new Label("Nº Expediente");
		labelExpediente.setBounds(184, 10, 147, 36);
		panel.add(labelExpediente);
		
		nombreTxt = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(347, 45, 134, 27);
		panel.add(nombreTxt);
		
		Label labelNombre = new Label("Nombre");
		labelNombre.setBounds(383, 10, 66, 29);
		panel.add(labelNombre);
		
		apellidoTxt = new TextField();
		apellidoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		apellidoTxt.setBounds(494, 45, 134, 27);
		panel.add(apellidoTxt);
		
		Label labelApellido = new Label("Apellidos");
		labelApellido.setBounds(520, 10, 108, 29);
		panel.add(labelApellido);
		
		Label labelIDProyecto = new Label("ID_Proyecto");
		labelIDProyecto.setBounds(669, 10, 142, 29);
		panel.add(labelIDProyecto);
		
	 	IDProyectoTxt = new TextField();
		IDProyectoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		IDProyectoTxt.setBounds(652, 45, 142, 27);
		panel.add(IDProyectoTxt);
		
		JButton filtroBtn = new JButton("Buscar");
		filtroBtn.setBounds(827, 49, 89, 23);
		filtroAlumnoListener filtroListener = new filtroAlumnoListener(this);
		filtroBtn.addActionListener(filtroListener);
		panel.add(filtroBtn);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 939, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 128, 255));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"ID_Alumnos", "N\u00BA expendiente", "Nombre", "Apellidos", "ID_Proyecto"});
		
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		listaAlumnos = acceso.listaAlumnos("SELECT * FROM ALUMNO");
		for (Alumno alumno : listaAlumnos) {
            Object[] row = {alumno.getIdAlumno(),alumno.getnExpediente(), alumno.getNombre(), alumno.getApellidos(), alumno.getIdProyecto()};
            model.addRow(row);
        }
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		// BOTONES EXTRA

		modAlumnoBtn btnModificar = new modAlumnoBtn(this);
		JButton modButton = new JButton("Modificar");
		modButton.setBounds(350, 532, 89, 23);
		contentPane.add(modButton);
		modButton.addActionListener(btnModificar);

		eliminarAlumno btnEliminar = new eliminarAlumno(this);
		JButton delButton = new JButton("Eliminar");
		delButton.setBounds(500, 532, 89, 23);
		contentPane.add(delButton);
		delButton.addActionListener(btnEliminar);
	}

	/**
	 * Obtiene el nombre ingresado en el campo de texto.
	 * 
	 * @return El nombre ingresado.
	 */
	public String getNombre(){
		String nombre = nombreTxt.getText();
		return nombre;
	}

	/**
	 * Obtiene los apellidos ingresados en el campo de texto.
	 * 
	 * @return Los apellidos ingresados.
	 */
	public String getApellidos(){
		String apellidos = apellidoTxt.getText();
		return apellidos;
	}

	/**
	 * Obtiene el número de expediente ingresado en el campo de texto.
	 * 
	 * @return El número de expediente ingresado.
	 */
	public String getNExpediente(){
		String expediente = nExpedienteTxt.getText();
		return expediente;
	}

	/**
	 * Obtiene el ID del proyecto ingresado en el campo de texto.
	 * 
	 * @return El ID del proyecto ingresado.
	 */
	public String getIDProyecto(){
		String id = IDProyectoTxt.getText();
		return id;
	}

	/**
	 * Actualiza la tabla de alumnos con los datos obtenidos de la consulta.
	 * 
	 * @param query La consulta SQL para obtener los datos.
	 */

	public void actualizarTabla(String query){
		// Vaciamos la tabla
		model.setRowCount(0);
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		listaAlumnos = acceso.listaAlumnos(query);
		for (Alumno alumno : listaAlumnos) {
            Object[] row = {alumno.getIdAlumno(),alumno.getnExpediente(), alumno.getNombre(), alumno.getApellidos(), alumno.getIdProyecto()};
            model.addRow(row);
        }
		table.setModel(model);
	}

	/**
	 * Obtiene el ID del alumno seleccionado en la tabla.
	 * 
	 * @return El ID del alumno seleccionado.
	 */
	public Alumno seleccionTabla(){
		int filaSeleccionada = table.getSelectedRow();
		Alumno a;
		if (filaSeleccionada != -1){
			int id = (int) model.getValueAt(filaSeleccionada, 0);
			int nExpediente = (int) model.getValueAt(filaSeleccionada, 1);
			String nombre = (String) model.getValueAt(filaSeleccionada, 2);
			String apellidos = (String) model.getValueAt(filaSeleccionada, 3);
			int idProyecto = (int) model.getValueAt(filaSeleccionada, 4);

			a = new Alumno(id, nombre, apellidos, nExpediente, idProyecto);
			return a;
		}else{
			a = null;
			return a;
		}
		

	}
}



