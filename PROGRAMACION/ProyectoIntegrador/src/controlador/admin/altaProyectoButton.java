package controlador.admin;

import java.awt.event.*;
import modelo.AccesoBD;
import modelo.Proyecto;
import vistas.admin.AltaProyecto;

/**
 * Clase del botón para dar alta un proyecto nuevo
 */
public class altaProyectoButton implements ActionListener {
	// Variables
    private AltaProyecto ventana;
	/**
	 * Método constructor
	 * @param ventana - la ventana desde la que se llama
	 */
    public altaProyectoButton(AltaProyecto ventana) {
        this.ventana=ventana;
    }
	/** 
	 * Método cuando se pulsa el botón
	 * @param ev
	 */
    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        // Conexión con BBDD
		Proyecto p = ventana.getProyecto();
        AccesoBD access = new AccesoBD();
		access.altaProyecto(p, ventana);
	}
}
