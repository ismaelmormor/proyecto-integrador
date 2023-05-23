package vistas.alumno;

import java.sql.*;
import java.awt.*;

import controlador.alumno.MenuListenerA;
import controlador.alumno.filtroVProyectoListener;
import modelo.AccesoBD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ListaVProyectos extends JFrame {

	private TextField proyectoTxt, nombreTxt, cursoTxt, grupoTxt, yearTxt, notaTxt, areaTxt;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private MenuListenerA menuListener = new MenuListenerA(this);


	
	public ListaVProyectos() {
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
		item.setBackground(new Color(3, 8, 62));
		item.setRolloverEnabled(false);
		
		item.setIcon(resizedIcon);
		menuBar.add(item);

		//PI
		JMenu PI = new JMenu("P.I.");
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(menuListener);

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);

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
		//Login
		JMenu Login = new JMenu("Lógin");
		menuBar.add(Login);

		JMenuItem admin = new JMenuItem("Admin");
		Login.add(admin);

		admin.addActionListener(menuListener);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 20, 939, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		// Labels y text fields
		Label labelFiltros = new Label("Filtros");
		labelFiltros.setFont(new Font("Dialog", Font.PLAIN, 30));
		labelFiltros.setBounds(35, 10, 142, 62);
		panel.add(labelFiltros);

		Label labelProyecto = new Label("ID_Proyecto");
		labelProyecto.setBounds(184, 3, 147, 36);
		panel.add(labelProyecto);

		proyectoTxt= new TextField();
		proyectoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		proyectoTxt.setBounds(178, 45, 153, 27);
		panel.add(proyectoTxt);
		
		Label labelNombre = new Label("Nombre");
		labelNombre.setBounds(369, 10, 66, 29);
		panel.add(labelNombre);
		
		nombreTxt = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(347, 45, 108, 27);
		panel.add(nombreTxt);
		
		Label labelCurso = new Label("Curso");
		labelCurso.setBounds(471, 10, 49, 29);
		panel.add(labelCurso);
		
		cursoTxt = new TextField();
		cursoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		cursoTxt.setBounds(461, 45, 60, 27);
		panel.add(cursoTxt);
		
		Label labelGrupo = new Label("Grupo");
		labelGrupo.setBounds(531, 10, 60, 29);
		panel.add(labelGrupo);
		
	 	grupoTxt = new TextField();
		grupoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		grupoTxt.setBounds(531, 45, 60, 27);
		panel.add(grupoTxt);
		
		Label labelYear = new Label("Año");
		labelYear.setBounds(603, 18, 66, 21);
		panel.add(labelYear);

		yearTxt = new TextField();
		yearTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		yearTxt.setBounds(597, 45, 60, 27);
		panel.add(yearTxt);
		
		Label labelNota = new Label("Nota");
		labelNota.setBounds(675, 10, 43, 29);
		panel.add(labelNota);
		
		notaTxt = new TextField();
		notaTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		notaTxt.setBounds(663, 45, 60, 27);
		panel.add(notaTxt);
		
		Label labelArea = new Label("ID_Area");
		labelArea.setBounds(731, 10, 66, 29);
		panel.add(labelArea);
		
		areaTxt = new TextField();
		areaTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		areaTxt.setBounds(729, 45, 60, 27);
		panel.add(areaTxt);
		
		// Botón filtro
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(827, 49, 89, 23);
		panel.add(btnNewButton);

		filtroVProyectoListener filtro = new filtroVProyectoListener(this);
		btnNewButton.addActionListener(filtro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 939, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 128, 255));
		model.setColumnIdentifiers(new String[] {"ID_Proyecto", "Nombre", "Curso", "Grupo", "Año", "URL", "Nota", "ID_Area"});
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		Connection con = acceso.getConexion();
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Proyecto_Integrador");

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
		}
		
		table.setModel(model);
	}

		public int seleccionTabla(){
			int selectedRow = table.getSelectedRow();
			int id = -1;
			if (selectedRow != -1) {
				// Obtener los datos de la fila seleccionada
				Object[] rowData = new Object[table.getColumnCount()];
				for (int i = 0; i < table.getColumnCount(); i++) {
					rowData[i] = table.getValueAt(selectedRow, i);
				}
			
				// Hacer algo con los datos de la fila seleccionada
				// Por ejemplo, imprimir los valores
				id = (Integer) rowData[0];
				return id;
			}
			return id;
	
		}

		public String getProyecto() {
			return proyectoTxt.getText();
		}
		public String getNombre() {
			return nombreTxt.getText();
		}
		public String getCurso() {
			return cursoTxt.getText();
		}
		public String getGrupo() {
			return grupoTxt.getText();
		}
		public String getYear() {
			return yearTxt.getText();
		}
		public String getNota() {
			return notaTxt.getText();
		}
		public String getArea() {
			return areaTxt.getText();
		}
	}

