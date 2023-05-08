package vistas;

import java.awt.EventQueue;
import java.awt.Font;
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

public class Animacion3D extends JFrame {

	private JPanel contentPane;

	/**
	 * Creamos el frame
	 */
	public Animacion3D() {
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

		
		 // JLabel centrado con el texto especificado
		 JLabel texto = new JLabel("<html>Codigo de area: 005<br></br><br></br>Descripcion:<br></br>La animación 3D usa gráficos por computadora para que parezca que los objetos se mueven en un espacio tridimensional. Los artistas usan software de modelado 3D para crear los objetos. Después viene la manipulación, una representación virtual de un objeto o el esqueleto de un personaje.</html>");
		 texto.setFont(new Font("Arial", Font.PLAIN, 16));
		 texto.setHorizontalAlignment(JLabel.CENTER);
		 texto.setForeground(Color.white);
		 texto.setBounds(50, 50, 650, 250);
		 contentPane.add(texto);

		 //label ANIMACION
		 JLabel label3D = new JLabel("ANIMACION 3D");
		 label3D.setFont(new Font("Arial", Font.BOLD, 30));
		 label3D.setHorizontalAlignment(JLabel.CENTER);
		 label3D.setForeground(Color.WHITE);
		 label3D.setBounds(50, 50, 650, 30);
		 contentPane.add(label3D);
	}

}
