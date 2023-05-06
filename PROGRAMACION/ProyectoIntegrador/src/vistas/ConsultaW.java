package vistas;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ConsultaW
		extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public ConsultaW() {
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(3, 8, 62));
		contentPane.setToolTipText("");
		contentPane.setBorder(
				new EmptyBorder(5, 5, 5,
						5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		
		
		JMenu PI = new JMenu("P.I.");
		menuBar.add(PI);
		
		JMenuItem Consulta = new JMenuItem("Consulta");
		PI.add(Consulta);
		
		JMenuItem Alta = new JMenuItem("Alta");
		PI.add(Alta);

		Alta.addActionListener(new ActionListener() { //action listener que abre alta
		    public void actionPerformed(ActionEvent e) {
				dispose();
		        Alta ventanaAlta = new Alta();
		        ventanaAlta.setVisible(true);
		      
		    }
		});
		
		JMenuItem Baja = new JMenuItem("Baja");
		PI.add(Baja);
		
		JMenuItem Modificacion = new JMenuItem("Modificación");
		PI.add(Modificacion);
		
		JMenu Alumnos = new JMenu("Alumnos");
		menuBar.add(Alumnos);
		
		JMenu Area = new JMenu("Área");
		menuBar.add(Area);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 939, 114);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 939, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 128, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID_Proyecto", "Nombre", "Curso", "Grupo", "A\u00F1o", "URL", "Nota", "ID_Area", "Modificar", "Dar de baja "
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, Integer.class, Object.class, Integer.class, Integer.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(36);
		scrollPane.setViewportView(table);
		
		Label label_1 = new Label("ID_Proyecto");
		label_1.setBounds(189, 95, 147, 36);
		contentPane.add(label_1);
	}
}
