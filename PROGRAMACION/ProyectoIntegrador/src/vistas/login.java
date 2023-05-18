package vistas;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	public login() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(203, 44, 98, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(203, 144, 112, 45);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(362, 52, 130, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(362, 152, 130, 29);
		getContentPane().add(passwordField);
		
		final JLabel informacion = new JLabel("");
		informacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		informacion.setBounds(116, 290, 540, 173);
		
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			conexionbdd aBD1=new conexionbdd();
			
			public void actionPerformed(ActionEvent e) {
				String str1=textField.getText();
				String str2=new String(passwordField.getPassword());
				if(aBD1.getConexion(str1,str2)) {
					informacion.setText("Usuario "+str1+" Acceso conseguido!");
					
				}else {
					informacion.setText("Usuario "+str1+" Acceso fallo!");
				}
			}
		});
		
		getContentPane().add(informacion);
		
		
		
		setSize(800, 500);
	}
}
