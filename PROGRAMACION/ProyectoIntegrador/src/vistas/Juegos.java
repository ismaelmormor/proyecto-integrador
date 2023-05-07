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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Juegos extends JFrame {

	private JPanel contentPane;

	/**
	 * Creamos el frame
	 */
	public Juegos() {
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
		
		Consulta.addActionListener(new ActionListener() { //action listener que abre consulta 
		    public void actionPerformed(ActionEvent e) {
				dispose();
		        ConsultaW ventanaConsulta = new ConsultaW();
		        ventanaConsulta.setVisible(true);
		      
		    }
		});

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(new ActionListener() { //action listener que abre alta
		    public void actionPerformed(ActionEvent e) {
		        Alta ventanaAlta = new Alta();
		        ventanaAlta.setVisible(true);
		      
		    }
		});

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        ListaDeAlumnos ventanaLista = new ListaDeAlumnos();
		        ventanaLista.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		Añadir.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Add_Alumno ventanaAdd_Alumno = new Add_Alumno();
		        ventanaAdd_Alumno.setVisible(true);
				
		      
		    }
		});

		//Area
		JMenu Area = new JMenu("Área");
		menuBar.add(Area);
		
		JMenuItem Daw = new JMenuItem("DAW");
		Area.add(Daw);

		Daw.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        DAW ventanaDAW = new DAW();
		        ventanaDAW.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Dam = new JMenuItem("DAM");
		Area.add(Dam);
		
		Dam.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        DAM ventanaDAM = new DAM();
		        ventanaDAM.setVisible(true);
				
		      
		    }
		});

		JMenuItem Asir = new JMenuItem("ASIR");
		Area.add(Asir);

		Asir.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Asir ventanaAsir = new Asir();
		        ventanaAsir.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Animacion = new JMenuItem("ANIMACIONES 3D");
		Area.add(Animacion);

		Animacion.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Animacion3D ventanaAnim = new Animacion3D();
		        ventanaAnim.setVisible(true);
				
		      
		    }
		});
		
		JMenuItem Juegos = new JMenuItem("VIDEOJUEGOS");
		Area.add(Juegos);

		Juegos.addActionListener(new ActionListener() { //action listener que abre lista de alumnos
		    public void actionPerformed(ActionEvent e) {
		        Juegos ventanaJuegos = new Juegos();
		        ventanaJuegos.setVisible(true);
				
		      
		    }
		});
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(3, 8, 62));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
