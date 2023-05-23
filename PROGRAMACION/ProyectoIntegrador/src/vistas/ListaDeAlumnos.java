package vistas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

import controlador.MenuListener;
import controlador.filtroAlumnoListener;
import modelo.AccesoBD;


public class ListaDeAlumnos
		extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private MenuListener menuListener = new MenuListener(this);	

	private TextField nExpedienteTxt, nombreTxt, apellidoTxt, IDProyectoTxt;
	/**
	 * 
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
		panel.setBounds(10, 86, 939, 114);
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
		scrollPane.setBounds(10, 233, 939, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 128, 255));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"ID_Alumnos", "N\u00BA expendiente", "Nombre", "Apellidos", "ID_Proyecto"});
		
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		Connection con = acceso.getConexion();
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Alumno");
			
			while (resultSet.next()) {
				Object[] row = new Object[model.getColumnCount()];
				
				for (int i = 1; i <= row.length; i++) {
					row[i-1] = resultSet.getObject(i);
					
				}

				model.addRow(row);
			}			
		} catch (Exception e) {
			System.out.println("Error con la consulta de Proyectos: "+e.getMessage());
		}
		
		table.setModel(model);
		
		scrollPane.setViewportView(table);
	}

	public String getNombre(){
		String nombre = nombreTxt.getText();
		return nombre;
	}
	public String getApellidos(){
		String apellidos = apellidoTxt.getText();
		return apellidos;
	}
	public String getNExpediente(){
		String expediente = nExpedienteTxt.getText();
		return expediente;
	}
	public String getIDProyecto(){
		String id = IDProyectoTxt.getText();
		return id;
	}

	public void actualizarTabla(String query){
		// Vaciamos la tabla
		model.setRowCount(0);
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		Connection con = acceso.getConexion();
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Object[] row = new Object[model.getColumnCount()];
				for (int i = 1; i <= row.length; i++) {
					row[i-1] = resultSet.getObject(i);
				}
				model.addRow(row);
			}			
		} catch (Exception e) {
			System.out.println("Error con la consulta de Proyectos: "+e.getMessage());
			// TODO: handle exception
		}
		
		table.setModel(model);
	}
}



