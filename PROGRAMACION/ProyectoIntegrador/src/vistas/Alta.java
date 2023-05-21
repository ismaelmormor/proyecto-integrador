package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.MenuListener;
import modelo.AccesoBD;
import modelo.AccesoBDinsert;

public class Alta  extends JFrame {

	private JPanel contentPane;
	private MenuListener menuListener = new MenuListener(this);	

	/**
	 * Create the frame.
	 */
	
	public Alta() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		ImageIcon img=new ImageIcon("D:\\DAW\\Javalearn\\Proyecto2023\\src\\logo.png");
		Image logo=img.getImage().getScaledInstance(40, 40, DO_NOTHING_ON_CLOSE);
		ImageIcon logo1=new ImageIcon(logo);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(3, 8, 62));
		contentPane.setBorder(
				new EmptyBorder(5, 5, 5,
						5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar);

		menuBar.setBounds(0, 0, 959, 59);
		
		
		JLabel ic = new JLabel("");
		ic.setIcon(logo1);
		menuBar.add(ic);
		
		//PI
		JMenu PI = new JMenu("P.I.");
		PI.setForeground(Color.white);
		menuBar.add(PI);

		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		Consulta.addActionListener(menuListener);

		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(menuListener);

		//Alumnos
		JMenu Alumnos = new JMenu("Alumnos");
		Alumnos.setForeground(Color.white);
		menuBar.add(Alumnos);
		
		JMenuItem Lista = new JMenuItem("Lista de Alumnos");
		Alumnos.add(Lista);

		Lista.addActionListener(menuListener);
		
		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		Añadir.addActionListener(menuListener);

		//Area
		JMenu Area = new JMenu("Área");
		Area.setForeground(Color.white);
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
		panel.setBounds(10, 86, 939, 524);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TextField nombre = new TextField();
		nombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombre.setBounds(434, 85, 153, 27);
		panel.add(nombre);
		
		TextField curso = new TextField();
		curso.setFont(new Font("Dialog", Font.PLAIN, 20));
		curso.setBounds(434, 136, 153, 27);
		panel.add(curso);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(318, 83, 66, 29);
		panel.add(label_1_1);
		
		TextField grupo = new TextField();
		grupo.setFont(new Font("Dialog", Font.PLAIN, 20));
		grupo.setBounds(434, 192, 153, 27);
		panel.add(grupo);
		
		Label label_1_1_1 = new Label("Curso");
		label_1_1_1.setBounds(335, 134, 49, 29);
		panel.add(label_1_1_1);
		
		TextField year = new TextField();
		year.setFont(new Font("Dialog", Font.PLAIN, 20));
		year.setBounds(434, 243, 153, 27);
		panel.add(year);
		
		Label label_1_1_1_1_1 = new Label("Año");
		label_1_1_1_1_1.setBounds(341, 243, 43, 29);
		panel.add(label_1_1_1_1_1);
		
		TextField link = new TextField();
		link.setFont(new Font("Dialog", Font.PLAIN, 20));
		link.setBounds(434, 293, 153, 27);
		panel.add(link);

		TextField nota = new TextField();
		nota.setFont(new Font("Dialog", Font.PLAIN, 20));
		nota.setBounds(434, 347, 153, 27);
		panel.add(nota);

		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(369, 413, 143, 43);
		//btn para insertar los datos al BD.
		btnNewButton.addActionListener(new ActionListener() {
			AccesoBDinsert addDatos=new AccesoBDinsert();
			public void actionPerformed(ActionEvent e) {
				String name=nombre.getText();
				String course=curso.getText();
				String group=grupo.getText();
				String año=year.getText();
				String url=link.getText();
				String note=nota.getText();
				addDatos.getConexion(name, course, group, año, url, note);
			}

		});
		panel.add(btnNewButton);
		
		Label label_1_1_1_1 = new Label("Grupo");
		label_1_1_1_1.setBounds(335, 190, 49, 29);
		panel.add(label_1_1_1_1);
		
		Label label_1_1_1_1_1_1 = new Label("URL");
		label_1_1_1_1_1_1.setBounds(341, 293, 43, 29);
		panel.add(label_1_1_1_1_1_1);
		
		
		
		Label label_1_1_1_1_1_1_1 = new Label("Nota");
		label_1_1_1_1_1_1_1.setBounds(341, 345, 43, 29);
		panel.add(label_1_1_1_1_1_1_1);
		



	}
}


