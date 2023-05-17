package main;

import java.awt.*;

import vistas.VentanaPrincipal;
/*
 * Creación de la clase main para ejecutar la aplicación
 */
public class AppGrafica {

	public static void main(String[] args) { //s
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Creamos y hacemos visible la ventana principal de la aplicación
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.hacerVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
