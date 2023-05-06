package vistas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Color;

public class Consulta extends JFrame {

	private JPanel contentPane;

	/**
	 * Creamos el frame
	 */
	public Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 410);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		ImageIcon logo = new ImageIcon("C:\\Users\\santi\\Downloads\\logo.png");
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

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		JMenuItem Baja = new JMenuItem("Baja");
		PI.add(Baja);

		JMenuItem Modificacion = new JMenuItem("Modificación");
		PI.add(Modificacion);
	
		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		//Area
		JMenu Area = new JMenu("Área");
		menuBar.add(Area);
		
		JMenuItem Daw = new JMenuItem("DAW");
		Area.add(Daw);
		
		JMenuItem Dam = new JMenuItem("DAM");
		Area.add(Dam);
		
		JMenuItem Asir = new JMenuItem("ASIR");
		Area.add(Asir);
		
		JMenuItem Animacion = new JMenuItem("ANIMACIONES 3D");
		Area.add(Animacion);
		
		JMenuItem Juegos = new JMenuItem("VIDEOJUEGOS");
		Area.add(Juegos);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
