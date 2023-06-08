package vistas.alumno;

import java.util.ArrayList;
import java.awt.*;

import controlador.alumno.MenuListenerA;
import controlador.alumno.filtroVProyectoListener;
import modelo.AccesoBD;
import modelo.Proyecto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase representa una ventana de GUI que muestra una lista de proyectos.
 * Extiende la clase JFrame.
 * Proporciona funcionalidad para filtrar y actualizar la lista de proyectos.
 */
public class ListaVProyectos extends JFrame {

	private TextField proyectoTxt, nombreTxt, cursoTxt, grupoTxt, yearTxt, notaTxt, areaTxt;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private MenuListenerA menuListener = new MenuListenerA(this);
	private ArrayList<Proyecto> listaProyectos;

	/**
	 * Constructor de la clase ListaVProyectos.
	 * Crea el frame de la ventana y configura sus propiedades.
	 */
	public ListaVProyectos() {
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

		// PI
		JMenu PI = new JMenu("P.I.");
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);

		Consulta.addActionListener(menuListener);

		// Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);

		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);

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
		// Login
		JMenu Login = new JMenu("Login");
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

		proyectoTxt = new TextField();
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
		model.setColumnIdentifiers(
				new String[] { "ID_Proyecto", "Nombre", "Curso", "Grupo", "Año", "URL", "Nota", "ID_Area" });
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		listaProyectos = acceso.listaProyectos("SELECT * FROM PROYECTO_INTEGRADOR");
		for (Proyecto proyecto : listaProyectos) {
            Object[] row = {proyecto.getIdProyecto(), proyecto.getNombre(), proyecto.getCurso(),
				 proyecto.getCurso(), proyecto.getYear(), proyecto.getUrl(), proyecto.getNota(),
				 proyecto.getIdArea()};
            model.addRow(row);
        }
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	/**
	 * Actualiza la tabla de proyectos con los resultados de una consulta filtrada.
	 *
	 * @param query Consulta filtrada para obtener los proyectos deseados.
	 */
	public void actualizarTabla(String query) {
		// Vaciamos la tabla
		model.setRowCount(0);
		// Sacamos los datos de la BD
		AccesoBD acceso = new AccesoBD();
		listaProyectos = acceso.listaProyectos(query);
		for (Proyecto proyecto : listaProyectos) {
            Object[] row = {proyecto.getIdProyecto(), proyecto.getNombre(), proyecto.getCurso(),
				 proyecto.getCurso(), proyecto.getYear(), proyecto.getUrl(), proyecto.getNota(),
				 proyecto.getIdArea()};
            model.addRow(row);
        }
		table.setModel(model);
	}

	/**
	 * Método que obtiene el proyecto seleccionado
	 *
	 * @return Proyecto seleccionado o null si no está seleccionado
	 */
	public Proyecto seleccionTabla() {
		int filaSeleccionada = table.getSelectedRow();
		Proyecto p;
		if (filaSeleccionada != -1){
			int id = (int) model.getValueAt(filaSeleccionada, 0);
			String nombre = (String) model.getValueAt(filaSeleccionada, 1);
			String curso = (String) model.getValueAt(filaSeleccionada, 2);
			String grupo = (String) model.getValueAt(filaSeleccionada, 3);
			int year = (int) model.getValueAt(filaSeleccionada, 4);
			String link = (String) model.getValueAt(filaSeleccionada, 5);
			int nota = (int) model.getValueAt(filaSeleccionada, 6);
			int area = (int) model.getValueAt(filaSeleccionada, 7);

			p = new Proyecto(id, nombre, curso, grupo, year, link, nota, area);
			return p;
		}else{
			p = null;
			return p;
		}
	}

	 /**
     * Obtiene el texto ingresado en el campo de texto "proyectoTxt".
     *
     * @return Texto ingresado en el campo de texto "proyectoTxt".
     */
	public String getProyecto() {
		return proyectoTxt.getText();
	}

	/**
     * Obtiene el texto ingresado en el campo de texto "nombreTxt".
     *
     * @return Texto ingresado en el campo de texto "nombreTxt".
     */
	public String getNombre() {
		return nombreTxt.getText();
	}

	/**
     * Obtiene el texto ingresado en el campo de texto "cursoTxt".
     *
     * @return Texto ingresado en el campo de texto "cursoTxt".
     */
	public String getCurso() {
		return cursoTxt.getText();
	}

	 /**
     * Obtiene el texto ingresado en el campo de texto "grupoTxt".
     *
     * @return Texto ingresado en el campo de texto "grupoTxt".
     */
	public String getGrupo() {
		return grupoTxt.getText();
	}

	/**
     * Obtiene el texto ingresado en el campo de texto "yearTxt".
     *
     * @return Texto ingresado en el campo de texto "yearTxt".
     */
	public String getYear() {
		return yearTxt.getText();
	}

	 /**
     * Obtiene el texto ingresado en el campo de texto "notaTxt".
     *
     * @return Texto ingresado en el campo de texto "notaTxt".
     */
	public String getNota() {
		return notaTxt.getText();
	}

	 /**
     * Obtiene el texto ingresado en el campo de texto "areaTxt".
     *
     * @return Texto ingresado en el campo de texto "areaTxt".
     */
	public String getArea() {
		return areaTxt.getText();
	}

	  /**
     * Obtiene el objeto JTable que muestra la lista de proyectos.
     *
     * @return Objeto JTable que muestra la lista de proyectos.
     */
	public Object getTable() {
		return table;
	}
}
