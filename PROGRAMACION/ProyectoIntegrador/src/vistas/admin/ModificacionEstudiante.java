package vistas.admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import controlador.admin.*;
import modelo.*;

/**
 * La clase ModificacionEstudiante crea el marco de la ventana y configura sus
 * propiedades.
 */
public class ModificacionEstudiante extends JFrame {
	private Alumno alumno,alumnoMod;
	private JPanel contentPane;
	private TextField nombreTxt, apellidosTxt, expedienteTxt, proyectoTxt;
	private Label error;
	private MenuListener menuListener = new MenuListener(this);

	/**
	 * Crea la ventana de ModificacionEstudiante.
	 * 
	 * @param id el ID del alumno a modificar.
	 */
	public ModificacionEstudiante(Alumno a) {
		this.alumno = a;
		
		Image icon = Toolkit.getDefaultToolkit().getImage("PROGRAMACION/ProyectoIntegrador/img/logo.png");
        this.setIconImage(icon);
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
		ImageIcon logo = new ImageIcon("PROGRAMACION/ProyectoIntegrador/img/logo.png");
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
		// Nº Expediente
		Label labelExpediente = new Label("Nº Expendiente");
		labelExpediente.setBounds(314, 83, 66, 29);
		panel.add(labelExpediente);

		expedienteTxt = new TextField();
		expedienteTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		expedienteTxt.setBounds(434, 85, 153, 27);
		expedienteTxt.setText(""+a.getnExpediente());
		panel.add(expedienteTxt);
		// Nombre
		Label labelNombre = new Label("Nombre");
		labelNombre.setBounds(316, 136, 66, 29);
		panel.add(labelNombre);

		nombreTxt = new TextField();
		nombreTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreTxt.setBounds(434, 136, 153, 27);
		nombreTxt.setText(a.getNombre());
		panel.add(nombreTxt);
		// Apellidos
		Label labelApellidos = new Label("Apellidos");
		labelApellidos.setBounds(314, 190, 66, 29);
		panel.add(labelApellidos);

		apellidosTxt = new TextField();
		apellidosTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		apellidosTxt.setBounds(434, 192, 153, 27);
		apellidosTxt.setText(a.getApellidos());
		panel.add(apellidosTxt);

		// Id proyecto
		Label labelProyecto = new Label("ID_Proyecto");
		labelProyecto.setBounds(314, 242, 66, 29);
		panel.add(labelProyecto);

		proyectoTxt = new TextField();
		proyectoTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		proyectoTxt.setBounds(434, 244, 153, 27);
		proyectoTxt.setText(""+a.getIdProyecto());
		panel.add(proyectoTxt);

		// Botón para modificar

		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(367, 363, 143, 43);

		modificarAlumno modificarBtn = new modificarAlumno(this);
		btnNewButton.addActionListener(modificarBtn);
		panel.add(btnNewButton);
		// --------------------
		error = new Label("");
		error.setBounds(270, 410, 330, 30);
		error.setForeground(new Color(255, 0 , 0));
		panel.add(error);

	}

	/**
	 * Método para recibir el alumno ya modificado
	 * @return alumno - Obeto Alumno modificado
	 */
	public Alumno getAlumnoMod() {
		String nombre = nombreTxt.getText();
		String apellidos = apellidosTxt.getText();
		int nExpediente = 0;
		int idProyecto = 0;
		// Validación del campo nExpediente
		String nExpedienteStr = expedienteTxt.getText();
		if (!nExpedienteStr.isEmpty()) {
			try {
				if(nExpedienteStr.length()>9){
					error.setText("El campo Nº Expediente debe tener 9 o menos cifras");
					return null;  // Retorna null si hay un error de validación
				}else{
					nExpediente = Integer.parseInt(nExpedienteStr);
				}
			} catch (NumberFormatException e) {
				nExpediente = 0;
				error.setText("El campo Nº Expediente debe ser un número válido");
				return null;  // Retorna null si hay un error de validación
			}
		}
		// Validación del campo idProyecto
		String idProyectoStr = proyectoTxt.getText();
		if (!idProyectoStr.isEmpty()) {
			try {
				idProyecto = Integer.parseInt(idProyectoStr);
			} catch (NumberFormatException e) {
				idProyecto = 0;
				error.setText("El campo ID Proyecto debe ser un número válido");
				return null;  // Retorna null si hay un error de validación
			}
		}else{
			error.setText("El campo ID Proyecto debe rellenarse");
			return null;  // Retorna null si hay un error de validación
		}
		
		error.setText("");

		alumnoMod = new Alumno(alumno.getIdAlumno(), nombre, apellidos, nExpediente, idProyecto);
		return alumnoMod;
	}
}
