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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * sea crea el frame
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 410);


        //menu
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
		        Consulta ventanaConsulta = new Consulta();
		        ventanaConsulta.setVisible(true);
		      
		    }
		});

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
		contentPane.setBackground(new Color(3, 8, 62));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JLabel "Daweishine8"
		JLabel labelDaweishine8 = new JLabel("Daweishine8");
		labelDaweishine8.setFont(new Font("Arial", Font.BOLD, 40));
		labelDaweishine8.setForeground(Color.WHITE);
		labelDaweishine8.setHorizontalAlignment(JLabel.CENTER);
		labelDaweishine8.setBounds(-122, 43, 650, 30);
		contentPane.add(labelDaweishine8);

		// JLabel en el centro
		JLabel label = new JLabel("<html>INTRODUCCION<br><br>P.I. Para usar el programa<br><br>- Alta: Para dar de alta a un alumno en el programa<br>- Consulta: para ver los datos y tener la posibilidad de modificarlos o borrarlos</html>");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(50, 100, 650, 150);
		contentPane.add(label);	
		
		
		// JLabel con imagen a la derecha
		Image resizedImage2 = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		JLabel labelImagen = new JLabel(resizedIcon2);
		labelImagen.setBounds(506, 25, 100, 100);
		contentPane.add(labelImagen);
}

	

    public	void hacerVisible() {
		setVisible(true);
	}

}