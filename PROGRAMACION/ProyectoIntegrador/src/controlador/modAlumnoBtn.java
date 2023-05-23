package controlador;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.AltaProyecto;
import vistas.ListaDeAlumnos;
import vistas.ModificacionEstudiante;

public class modAlumnoBtn implements ActionListener {
    private String id;
    private ListaDeAlumnos ventana;
    private Connection con;

    public modAlumnoBtn(ListaDeAlumnos ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        id = ventana.seleccionTabla();
        if (id != null){
            ModificacionEstudiante ventanaNueva = new ModificacionEstudiante(id);
            ventana.dispose();
            ventanaNueva.setVisible(true);
        }
        else{
            showMessageDialog("Selecciona una fila de la tabla");
        }
    }
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
