package vistas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import controlador.MenuListener;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultCellEditor;


public class ConsultaW
		extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private MenuListener menuListener = new MenuListener(this);	


	
	public ConsultaW() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(
				new EmptyBorder(5, 5, 5,
						5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar);
		menuBar.setForeground(new Color(3, 8, 62));
		menuBar.setBackground(new Color(3, 8, 62));
		menuBar.setBounds(0, 0, 959, 59);
		
		ImageIcon logo = new ImageIcon("C:\\Users\\santi\\Downloads\\logo.png");
		Image originalImage = logo.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JMenuItem item = new JMenuItem(resizedIcon);
		item.setRolloverEnabled(false);
		item.setForeground(new Color(3, 8, 62));
		item.setBackground(new Color(3, 8, 62));
		item.setIcon(resizedIcon);
		menuBar.add(item);
		
		
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
		panel.setBounds(10, 86, 939, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TextField textField = new TextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField.setBounds(178, 45, 153, 27);
		panel.add(textField);
		
		Label label = new Label("Filtros");
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setBounds(35, 10, 142, 62);
		panel.add(label);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setBounds(347, 45, 108, 27);
		panel.add(textField_1);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(369, 10, 66, 29);
		panel.add(label_1_1);
		
		TextField textField_1_1 = new TextField();
		textField_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1.setBounds(461, 45, 60, 27);
		panel.add(textField_1_1);
		
		Label label_1_1_1 = new Label("Curso");
		label_1_1_1.setBounds(471, 10, 49, 29);
		panel.add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("Grupo");
		label_1_1_1_1.setBounds(531, 10, 60, 29);
		panel.add(label_1_1_1_1);
		
		TextField textField_1_1_1 = new TextField();
		textField_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1.setBounds(531, 45, 60, 27);
		panel.add(textField_1_1_1);
		
		TextField textField_1_1_1_1 = new TextField();
		textField_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1.setBounds(597, 45, 60, 27);
		panel.add(textField_1_1_1_1);
		
		Label label_1_1_1_1_1 = new Label("Año");
		label_1_1_1_1_1.setBounds(603, 18, 66, 21);
		panel.add(label_1_1_1_1_1);
		
		Label label_1_1_2 = new Label("Nota");
		label_1_1_2.setBounds(675, 10, 43, 29);
		panel.add(label_1_1_2);
		
		TextField textField_1_1_1_1_1 = new TextField();
		textField_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1_1.setBounds(663, 45, 60, 27);
		panel.add(textField_1_1_1_1_1);
		
		Label label_1_1_2_1 = new Label("ID_Area");
		label_1_1_2_1.setBounds(731, 10, 66, 29);
		panel.add(label_1_1_2_1);
		
		TextField textField_1_1_1_1_1_1 = new TextField();
		textField_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1_1_1.setBounds(729, 45, 60, 27);
		panel.add(textField_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(827, 49, 89, 23);
		panel.add(btnNewButton);
		
		Label label_1 = new Label("ID_Proyecto");
		label_1.setBounds(184, 3, 147, 36);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 939, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 128, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null,null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID_Proyecto", "Nombre", "Curso", "Grupo", "A\u00F1o", "URL", "Nota", "ID_Area", ""
			}
		));

		Vector<Object> v=new Vector<Object>();
		v.add("Modificar");
		v.add("Dar de baja");
		JComboBox<Object> comboBox = new JComboBox<Object>(v);
		table.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(comboBox));
		scrollPane.setViewportView(table);
		
		
	}
}

