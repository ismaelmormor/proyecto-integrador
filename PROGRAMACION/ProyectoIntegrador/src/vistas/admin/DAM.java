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
 * Constructor de la clase Dam.
 * Crea el frame de la ventana y configura sus propiedades.
 */
public class DAM extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);	

	/**
	 * Constructor de la clase Dam.
	 * Crea el frame de la ventana y configura sus propiedades.
	 */
	public DAM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		setLocationRelativeTo(null);
		setResizable(false);

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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(3, 8, 62));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

                // JLabel centrado con el texto especificado
                JLabel texto = new JLabel("<html>Codigo de area: 002<br></br><br></br>Descripcion:<br></br>El desarrollo de aplicaciones multiplataforma es una estrategia que utiliza software para crear aplicaciones para las plataformas iOS y Android simultáneamente. Esto permite a las empresas llegar a una base de clientes más amplia proporcionándoles una aplicación compatible con varios dispositivos.</html>");
				texto.setFont(new Font("Arial", Font.PLAIN, 20));
				texto.setHorizontalAlignment(JLabel.CENTER);
				texto.setForeground(Color.white);
				texto.setBounds(163, 228, 650, 250);
                contentPane.add(texto);

                //label dam
                JLabel labelDAM = new JLabel("DAM");
                labelDAM.setFont(new Font("Arial", Font.BOLD, 35));
		  		labelDAM.setHorizontalAlignment(JLabel.CENTER);
	      		labelDAM.setForeground(Color.WHITE);
		  		labelDAM.setBounds(138, 111, 650, 30);
                contentPane.add(labelDAM);
	}

}
