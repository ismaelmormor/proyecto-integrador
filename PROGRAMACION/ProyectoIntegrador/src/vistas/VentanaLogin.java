package vistas;

import javax.swing.*;
import javax.swing.JFrame;

import controlador.MenuListener;
import controlador.loginButton;

import java.awt.*;

public class VentanaLogin extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;
	
	public VentanaLogin() {
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
		getContentPane().add(informacion);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(362, 300, 130, 29);
		loginButton loginBtn = new loginButton(this);
		btnNewButton.addActionListener(loginBtn);
		getContentPane().add(btnNewButton);

		setSize(800, 500);
	}

	public String getUser(){
		String str1=textField.getText();
		return str1;
	}
	public String getPassword(){
		String str1=new String(passwordField.getPassword());
		return str1;
	}
    public void hacerVisible() {
		setVisible(true);
	}
}
