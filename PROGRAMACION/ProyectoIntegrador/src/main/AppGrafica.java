package main;

import java.awt.*;

import vistas.alumno.VentanaVistaAlumno;
/*
 * Creación de la clase main para ejecutar la aplicación
 */
public class AppGrafica {

	public static void main(String[] args) { //s
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Creamos y hacemos visible la ventana principal de la aplicación
					VentanaVistaAlumno frame = new VentanaVistaAlumno();
					Image icon = Toolkit.getDefaultToolkit().getImage("PROGRAMACION/ProyectoIntegrador/img/logo.png");
                    frame.setIconImage(icon);
					frame.hacerVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
