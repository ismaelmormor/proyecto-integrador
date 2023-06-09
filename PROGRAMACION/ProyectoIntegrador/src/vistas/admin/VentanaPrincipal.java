package vistas.admin;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.admin.MenuListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

/**
 * La clase VentanaPrincipal representa la ventana principal del sistema para el
 * administrador.
 * Proporciona un menú y opciones para interactuar con el programa.
 */
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);

	/**
	 * Crea una instancia de la clase VentanaPrincipal.
	 * Configura la apariencia y los componentes de la ventana principal.
	 */
	public VentanaPrincipal() {
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
		contentPane.setBackground(new Color(3, 8, 62));
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

		// JLabel "Daweishine8"
		JLabel labelDaweishine8 = new JLabel("Daweishine8");
		labelDaweishine8.setFont(new Font("Arial", Font.BOLD, 47));
		labelDaweishine8.setForeground(Color.WHITE);
		labelDaweishine8.setHorizontalAlignment(JLabel.CENTER);
		labelDaweishine8.setBounds(-90, 96, 709, 109);
		contentPane.add(labelDaweishine8);

		// JLabel en el centro
		JLabel label = new JLabel(
				"<html>VISTA ADMIN<br><br>Bienvenido a la vista de administrador! Aquí podras:<br><br>- Dar Alta: Para dar de alta a un alumno o proyecto en el programa<br>"+
				"- Consulta: para ver los datos y tener la posibilidad de modificarlos o borrarlos<br>Recuerda que puedes echarle un ojo al manual de usuario si necesitas más ayuda</html>");
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
	 * Hace visible la ventana principal.
	 */
	public void hacerVisible() {
		setVisible(true);
	}

}
