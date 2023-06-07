package controlador.admin;
// Imports
import java.awt.event.*;
import modelo.AccesoBD;
import modelo.Alumno;
import vistas.admin.AltaAlumno;
/**
 * Clase del botón para dar alta a un alumno nuevo
 */
public class altaAlumnoButton implements ActionListener {
    private AltaAlumno ventana;
	/**
	 * Método constructor
	 * @param ventana - la ventana desde donde se llama
	 */
    public altaAlumnoButton(AltaAlumno ventana) {
        this.ventana=ventana;
    }

	/** 
	 * Método cuando se pulsa el botón
	 * @param ev
	 */
	@Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
		Alumno a = ventana.getAlumno();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
		access.altaAlumno(a, ventana);
	}
}
