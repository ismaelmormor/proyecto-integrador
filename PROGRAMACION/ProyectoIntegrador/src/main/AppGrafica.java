package main;

import java.awt.*;

import vistas.VentanaLogin;
/*
 * Creación de la clase main para ejecutar la aplicación
 */
public class AppGrafica {

	public static void main(String[] args) { //s
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Creamos y hacemos visible la ventana principal de la aplicación
					VentanaLogin frame = new VentanaLogin();
					frame.hacerVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
