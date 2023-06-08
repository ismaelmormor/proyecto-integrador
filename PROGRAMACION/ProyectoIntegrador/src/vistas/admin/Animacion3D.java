package vistas.admin;

import java.awt.Font;
import java.awt.Image;

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
 * Clase que representa la ventana de animación3D.
 * Extiende JFrame para crear el frame de la ventana.
 */
public class Animacion3D extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);

	/**
	 * Constructor de la clase Animacion3DA.
	 * Crea el frame de la ventana y configura sus propiedades.
	 */
	public Animacion3D() {
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

		// JLabel centrado con el texto especificado
		JLabel texto = new JLabel(
				"<html>Codigo de area: 005<br></br><br></br>Descripcion:<br></br>La animación 3D usa gráficos por computadora para que parezca que los objetos se mueven en un espacio tridimensional. Los artistas usan software de modelado 3D para crear los objetos. Después viene la manipulación, una representación virtual de un objeto o el esqueleto de un personaje.</html>");
		texto.setFont(new Font("Arial", Font.PLAIN, 20));
		texto.setHorizontalAlignment(JLabel.CENTER);
		texto.setForeground(Color.white);
		texto.setBounds(163, 228, 650, 250);
		contentPane.add(texto);

		// label ANIMACION
		JLabel label3D = new JLabel("ANIMACION 3D");
		label3D.setFont(new Font("Arial", Font.BOLD, 35));
		label3D.setHorizontalAlignment(JLabel.CENTER);
		label3D.setForeground(Color.WHITE);
		label3D.setBounds(138, 111, 650, 30);
		contentPane.add(label3D);
	}

}
