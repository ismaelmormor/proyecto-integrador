package controlador.admin;

import java.awt.event.*;

import modelo.AccesoBD;
import modelo.Alumno;
import vistas.admin.ModificacionEstudiante;
/**
 * Clase para modificar los datos de un alumno en la base de datos
 */
public class modificarAlumno implements ActionListener {
    // Variables
    private Alumno a;
    private ModificacionEstudiante ventana;
    /**
     * Método constructor de la clase
     * @param ventana - ventana desde donde se llama
     */
    public modificarAlumno(ModificacionEstudiante ventana) {
        this.ventana=ventana;
    }
    /**
     * Método cuando se pulsa el botón
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        a = ventana.getAlumnoMod();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        access.modAlumno(a, ventana);

    }
}
