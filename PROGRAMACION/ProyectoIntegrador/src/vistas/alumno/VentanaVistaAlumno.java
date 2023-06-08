package vistas.alumno;

import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.alumno.MenuListenerA;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

/**
 * Esta clase representa la ventana de la vista del alumno en el programa.
 * Extiende la clase JFrame y muestra un menú con diferentes opciones.
 * Proporciona funcionalidad para interactuar con el menú y mostrar la información correspondiente.
 */
public class VentanaVistaAlumno extends JFrame {

	private JPanel contentPane;
	private MenuListenerA menuListener = new MenuListenerA(this);	

	/**
 	* Constructor de la clase VentanaVistaAlumno.
    * Crea el frame de la ventana y configura sus propiedades.
 	*/
	public VentanaVistaAlumno() {
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
		ImageIcon logo = new ImageIcon("PROGRAMACION/ProyectoIntegrador/img/logo.png");
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

		// JLabel "Daweishine8"
		JLabel labelDaweishine8 = new JLabel("Daweishine8");
		labelDaweishine8.setFont(new Font("Arial", Font.BOLD, 47));
		labelDaweishine8.setForeground(Color.WHITE);
		labelDaweishine8.setHorizontalAlignment(JLabel.CENTER);
		labelDaweishine8.setBounds(-90, 96, 709, 109);
		contentPane.add(labelDaweishine8);

		// JLabel en el centro
		JLabel label = new JLabel("<html>VISTA ALUMNO<br><br>Bienvenido a la vista de alumno! Aquí podras:<br><br>"+
		"- Consulta: para ver los datos y tener la posibilidad de modificarlos o borrarlos<br>"+
		"<br>- Login Admin: para acceder a la vista de administrador y poder modificar datos.<br>Recuerda que puedes echarle un ojo al manual de usuario si necesitas más ayuda</html>");
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(125, 236, 720, 209);
		contentPane.add(label);	
		
		
		// JLabel con imagen a la derecha
		Image resizedImage2 = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		JLabel labelImagen = new JLabel(resizedIcon2);
		labelImagen.setBounds(629, 96, 125, 130);
		contentPane.add(labelImagen);
}

	
    /**
     * Hace visible la ventana del alumno.
     */
    public void hacerVisible() {
		setVisible(true);
	}

}
