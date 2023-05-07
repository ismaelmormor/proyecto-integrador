package vistas;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListaDeAlumnos
		extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	
	public ListaDeAlumnos() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		ImageIcon img=new ImageIcon("D:\\DAW\\Javalearn\\Proyecto2023\\src\\logo.png");
		Image logo=img.getImage().getScaledInstance(40, 40, DO_NOTHING_ON_CLOSE);
		ImageIcon logo1=new ImageIcon(logo);
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
		
		
		JLabel ic = new JLabel("");
		ic.setIcon(logo1);
		menuBar.add(ic);
		
		JMenu PI = new JMenu("P.I.");
		PI.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
		menuBar.add(PI);
		
		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);
		
		JMenuItem Baja = new JMenuItem("Baja");
		PI.add(Baja);
		
		JMenuItem Modificacion = new JMenuItem("Modificación");
		PI.add(Modificacion);
		
		JMenu Alumnos = new JMenu("Alumnos");
		Alumnos.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
		menuBar.add(Alumnos);

		JMenuItem Añadir = new JMenuItem("Añadir");
		Alumnos.add(Añadir);
		
		JMenu Area = new JMenu("Área");
		Area.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
		menuBar.add(Area);
		
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
		
		Label label_1 = new Label("Nº Expediente");
		label_1.setBounds(184, 10, 147, 36);
		panel.add(label_1);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setBounds(347, 45, 134, 27);
		panel.add(textField_1);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(383, 10, 66, 29);
		panel.add(label_1_1);
		
		TextField textField_1_1 = new TextField();
		textField_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1.setBounds(494, 45, 134, 27);
		panel.add(textField_1_1);
		
		Label label_1_1_1 = new Label("Apeilldo");
		label_1_1_1.setBounds(520, 10, 108, 29);
		panel.add(label_1_1_1);
		
		Label label_1_1_2_1 = new Label("ID_Proyecto");
		label_1_1_2_1.setBounds(669, 10, 142, 29);
		panel.add(label_1_1_2_1);
		
		TextField textField_1_1_1_1_1_1 = new TextField();
		textField_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1_1_1_1_1_1.setBounds(652, 45, 142, 27);
		panel.add(textField_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(827, 49, 89, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 939, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 128, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID_Alumnos", "N\u00BA expendiente", "Nombre", "Apeilldo", "ID_Proyecto", ""
			}
		));
		Vector<Object> v=new Vector<Object>();
		v.add("Modificar");
		v.add("Dar de baja");
		JComboBox<Object> comboBox = new JComboBox<Object>(v);
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboBox));
		scrollPane.setViewportView(table);
		
	}
}

