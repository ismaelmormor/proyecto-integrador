package vistas.admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controlador.admin.MenuListener;
import controlador.admin.altaAlumnoButton;
import modelo.Alumno;

import java.awt.*;

/**
 * Esta clase representa la ventana de alta de un alumno en el programa para el
 * administrador.
 * Extiende la clase JFrame y muestra un formulario para ingresar los datos del
 * alumno a añadir.
 * Proporciona funcionalidad para interactuar con el formulario y obtener los
 * datos ingresados.
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
	private Label error;

	/**
	 * Constructor de la clase AltaAlumno.
	 * Crea el frame de la ventana y configura sus propiedades.
	 */
	public AltaAlumno() {
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
		menuBar.setBackground(new Color(3, 8, 62));

		ImageIcon logo = new ImageIcon("PROGRAMACION/ProyectoIntegrador/img/logo.png");
		Image originalImage = logo.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JMenuItem item = new JMenuItem(resizedIcon);
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
		panel.setBounds(10, 52, 939, 524);
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
		
		nExpedienteTxt= new TextField();
		nExpedienteTxt.setFont(new Font("Dialog", Font.PLAIN, 20));
		nExpedienteTxt.setBounds(434, 192, 153, 27);
		panel.add(nExpedienteTxt);
		
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
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(3, 8, 62));
		btnNewButton.setBounds(367, 363, 143, 43);
		// -----------------------
		altaAlumnoButton altaAbtn = new altaAlumnoButton(this);
		btnNewButton.addActionListener(altaAbtn);
		panel.add(btnNewButton);
		// -----------------------
		error = new Label("");
		error.setBounds(270, 410, 330, 30);
		error.setForeground(new Color(255, 0 , 0));
		panel.add(error);

	}
	// -----------------------

	/**
	 * Obtiene el objeto Alumno de todos los datos introducidos
	 *
	 * @return Alumno
	 */
	public Alumno getAlumno() {
		String nombre = nombreTxt.getText();
		String apellido = apellidoTxt.getText();
		int nExpediente = 0;
		int idProyecto = 0;
		// Validación del campo nExpediente
		String nExpedienteStr = nExpedienteTxt.getText();
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
		String idProyectoStr = idProyectoTxt.getText();
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
		
		Alumno a = new Alumno(nombre, apellido, nExpediente, idProyecto);
		error.setText("");
		return a;
	}
}
