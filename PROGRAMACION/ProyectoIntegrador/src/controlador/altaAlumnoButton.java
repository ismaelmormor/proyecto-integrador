package controlador;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.AltaAlumno;
import vistas.AltaProyecto;
import vistas.VentanaLogin;
import vistas.VentanaPrincipal;

public class altaAlumnoButton implements ActionListener {
    private String nombre;
    private String apellido;
    private String nExpendiente;
    private String idProyecto;
    private AltaAlumno ventana;
    private Connection con;

    public altaAlumnoButton(AltaAlumno ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Recolección de datos
        nombre = ventana.getNombre();
        apellido = ventana.getApellido();
        nExpendiente = ventana.getNExpendiente();
        idProyecto = ventana.getIdProyecto();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        con = access.getConexion();

		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
            statement.executeUpdate("Insert into Proyecto_Integrador values('"+
                nombre+"','"+nombre+"','"+apellido+"','"+nExpendiente+"','"+idProyecto+"')");
            statement.close();
			con.close();

		} catch (Exception e) {
			System.out.println("error al establecer conexión con BD");
			// TODO: handle exception
		}
    }
    private void showMessageDialog(String message) {
		// Creamos el dialog
		final Dialog dialog = new Dialog(ventana, "Mensaje");
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