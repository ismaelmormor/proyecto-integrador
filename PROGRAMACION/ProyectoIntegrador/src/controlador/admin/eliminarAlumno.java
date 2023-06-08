package controlador.admin;

import java.awt.*;
import java.awt.event.*;
import modelo.AccesoBD;
import modelo.Alumno;
import vistas.admin.ListaDeAlumnos;

/**
 * Clase para cuando queremos eliminar un alumno
 */
public class eliminarAlumno implements ActionListener {
	// Variables
    private Alumno a;
    private ListaDeAlumnos ventana;

	/**
	 * Método constructor
	 * @param ventana - ventana desde donde se llama
	 */
    public eliminarAlumno(ListaDeAlumnos ventana) {
        this.ventana=ventana;
    }
	/**
	 * Método para cuando se pulsa el botón
	 */
    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        a = ventana.seleccionTabla();
		// Si la id que recopilamos no es -1 significa que hemos cogido la seleccionada
        if (a != null){
            AccesoBD access = new AccesoBD();
            access.eliminarAlumno(a, ventana);
        }
        else{
            showMessageDialog("Selecciona una fila de la tabla");
        }
    }
	/**
	 * Método de creación del dialog para las notificaciones
	 * @param message
	 */
    private void showMessageDialog(String message) {
		// Creamos el dialog
		Dialog dialog = new Dialog(ventana, "Mensaje");
		// Le damos forma con un layout
		dialog.setLayout(new BorderLayout());
		// Le añadimos el mensaje que traiga en el medio
		dialog.add(new Label(message), BorderLayout.CENTER);
		// Tambien añadimos un botón de confirmación, que cuando es pulsado, se cierra
		// este dialogo
		Button okButton = new Button("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		// Añadimos todo
		dialog.add(okButton, BorderLayout.SOUTH);
		dialog.pack();
		// La posición será con respecto de la ventana principal
		dialog.setLocationRelativeTo(ventana);
		dialog.setVisible(true);
	}
}
