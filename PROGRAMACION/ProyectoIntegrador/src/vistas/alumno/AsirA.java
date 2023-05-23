package vistas.alumno;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.alumno.MenuListenerA;
import modelo.AccesoBD;

public class AsirA extends JFrame {

	private JPanel contentPane;
	private String descripcion, nombre;
	private Connection con;
	private MenuListenerA menuListener = new MenuListenerA(this);

	/**
	 * Creamos el frame
	 */
	public AsirA() {
		// Establecemos que cuando se cierre la pestaña se acabe el programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ajustamos el tamaño de la ventana
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(3, 8, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5,5));
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
		JMenu Login = new JMenu("Login");
		menuBar.add(Login);

		JMenuItem admin = new JMenuItem("Admin");
		Login.add(admin);

		admin.addActionListener(menuListener);

		AccesoBD access = new AccesoBD();
		con = access.getConexion();

		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
			String query = "select * from AREAS where ID_AREA=3";
			ResultSet result = statement.executeQuery(query);
			nombre = result.getString("Nombre");
			descripcion = result.getString("Descripcion");
		} catch (Exception e) {
			System.out.println("Hubo un error: "+e.getMessage());
			// TODO: handle exception
		}

		 // JLabel centrado con el texto especificado
		 JLabel texto = new JLabel("<html>Codigo de area: 003<br></br><br></br>Descripcion:<br></br>"+descripcion+"</html>");
		 texto.setFont(new Font("Arial", Font.PLAIN, 20));
		 texto.setHorizontalAlignment(JLabel.CENTER);
		 texto.setForeground(Color.white);
		 texto.setBounds(163, 228, 650, 250);
		 contentPane.add(texto);

		 //label ANIMACION
		 JLabel label3D = new JLabel(nombre);
		 label3D.setFont(new Font("Arial", Font.BOLD, 35));
		 label3D.setHorizontalAlignment(JLabel.CENTER);
	     label3D.setForeground(Color.WHITE);
		 label3D.setBounds(138, 111, 650, 30);
		 contentPane.add(label3D);
	}

}
