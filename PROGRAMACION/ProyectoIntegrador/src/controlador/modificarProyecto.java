package controlador;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.ListaDeAlumnos;
import vistas.ModificacionEstudiante;
import vistas.ModificacionProyecto;

public class modificarProyecto implements ActionListener {
    private String nombre;
    private String curso;
    private String grupo;
    private String year;
    private String link;
    private String nota;
    private String id_area;
    private ModificacionProyecto ventana;
    private int idProyecto;
    private Connection con;

    public modificarProyecto(ModificacionProyecto ventana, int id) {
        this.ventana=ventana;
        this.idProyecto=id;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        nombre = ventana.getNombre();
        apellido = ventana.getApellidos();
        nExpendiente = ventana.getExpediente();
        idProyecto = ventana.getIdProyecto();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        con = access.getConexion();

		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
			String query = "UPDATE ALUMNO SET Nombre = '"
            +nombre+"', Apellidos='"+apellido+"', N_Expediente="+nExpendiente+", ID_Proyecto="+idProyecto+" where ID_Alumno="+idAlumno;
            statement.executeUpdate(query);
            statement.close();
			con.close();
			showMessageDialog("Se han introducido los datos correctamente");
            ventana.dispose();
            ListaDeAlumnos ventanaNueva = new ListaDeAlumnos();
            ventanaNueva.setVisible(true);

		} catch (Exception e) {
			System.out.println("Error con el botón de modificar Alumno: "+e.getMessage());
			showMessageDialog("Hubo un error al cambiar los datos");
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
