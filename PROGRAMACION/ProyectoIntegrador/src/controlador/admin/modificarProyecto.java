package controlador.admin;

import java.awt.event.*;

import modelo.AccesoBD;
import modelo.Proyecto;
import vistas.admin.ModificacionProyecto;
/**
 * Clase para modificar los datos de un alumno en la base de datos
 */
public class modificarProyecto implements ActionListener {
	// Variables
    private ModificacionProyecto ventana;
    private Proyecto p;
	/**
     * Método constructor de la clase
     * @param ventana - ventana desde donde se llama
     * @param id - la id del proyecto que queremos editar
     */
    public modificarProyecto(ModificacionProyecto ventana) {
        this.ventana=ventana;
    }
	/**
     * Método cuando se pulsa el botón
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        p = ventana.getProyectoMod();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        access.modProyecto(p, ventana);

    }
}