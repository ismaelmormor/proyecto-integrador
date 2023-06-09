package vistas.admin;

import javax.swing.*;
import javax.swing.JFrame;

import controlador.loginButton;

import java.awt.*;
/**
 * La clase VentanaLogin representa la ventana de inicio de sesión.
 * Permite al usuario ingresar su nombre de usuario y contraseña para acceder al sistema.
 */
public class VentanaLogin extends JFrame {

	public JTextField textField;
	public JPasswordField passwordField;
	
	/**
	 * Crea una instancia de la clase VentanaLogin.
	 * Configura la apariencia y los componentes de la ventana de inicio de sesión.
	 */
	public VentanaLogin() {
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		
		ImageIcon logo = new ImageIcon("proyecto-integrador/PROGRAMACION/ProyectoIntegrador/img/logo.png");
	        Image originalImage = logo.getImage();
	        Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        
	        JLabel imageLabel = new JLabel(resizedIcon);
	        imageLabel.setBounds(367, 51, 50, 50);
	        getContentPane().add(imageLabel);

			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setFont(new Font("HP Simplified", Font.PLAIN, 20));
			lblNewLabel.setBounds(200, 128, 98, 45);
			getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Contraseña:");
			lblNewLabel_1.setBackground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("HP Simplified", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(176, 219, 112, 45);
			getContentPane().add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setFont(new Font("HP Simplified", Font.PLAIN, 20));
			textField.setBounds(334, 136, 130, 29);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("HP Simplified", Font.PLAIN, 20));
			passwordField.setBounds(334, 227, 130, 29);
			getContentPane().add(passwordField);
			
			final JLabel informacion = new JLabel("");
			informacion.setFont(new Font("HP Simplified", Font.PLAIN, 20));
			informacion.setBounds(48, 290, 540, 173);
			getContentPane().add(informacion);
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.setBounds(334, 335, 130, 29);
			loginButton loginBtn = new loginButton(this);
			btnNewButton.addActionListener(loginBtn);
			getContentPane().add(btnNewButton);
			
		setSize(800, 500);
		setLocationRelativeTo(null);
	}

	/**
	 * Obtiene el nombre de usuario ingresado en el campo de texto.
	 * 
	 * @return el nombre de usuario ingresado.
	 */
	public String getUser(){
		String str1=textField.getText();
		return str1;
	}

	/**
	 * Obtiene la contraseña ingresada en el campo de texto.
	 * 
	 * @return la contraseña ingresada.
	 */
	public String getPassword(){
		String str1=new String(passwordField.getPassword());
		return str1;
	}
	
	/**
	 * Hace visible la ventana de inicio de sesión.
	 */
    public void hacerVisible() {
		setVisible(true);
	}
}
