package controlador.admin;

import java.awt.*;
import java.awt.event.*;

import modelo.Proyecto;
import vistas.admin.ListaProyectos;
import vistas.admin.ModificacionProyecto;
/**
 * Clase intermedia entre la llamada para modificar desde la tabla, 
 * que une con la ventana de modificar
 */
public class modProyectoBtn implements ActionListener {
	// Variables
    private Proyecto p;
    private ListaProyectos ventana;
	/**
	 * Método constructor
	 * @param ventana - ventana desde donde se llama
	 */
    public modProyectoBtn(ListaProyectos ventana) {
        this.ventana=ventana;
    }
	/**
	 * Método cuando se pulsa el botón
	 */
    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        p = ventana.seleccionTabla();
		// Si la id que recopilamos no es -1 significa que hemos cogido la seleccionada
		if (p != null){
            ModificacionProyecto ventanaNueva = new ModificacionProyecto(p);
            ventana.dispose();
            ventanaNueva.setVisible(true);
        }
        else{
            showMessageDialog("Selecciona una fila de la tabla");
        }
    }
	/**
	 * Método para crear y mostrar el dialog de la notificación
	 * @param message - el mensaje que queramos que salga
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
