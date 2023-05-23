package controlador;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.ListaDeAlumnos;
import vistas.ModificacionEstudiante;

public class modificarAlumno implements ActionListener {
    private String nombre;
    private String apellido;
    private String nExpendiente;
    private String idProyecto;
    private int idAlumno;
    private ModificacionEstudiante ventana;
    private Connection con;

    public modificarAlumno(ModificacionEstudiante ventana, int id) {
        this.ventana=ventana;
        this.idAlumno=id;
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

		} catch (SQLException e) {
            if (e.getErrorCode() == 1452) {
                showMessageDialog("ID_Proyecto tiene que existir");
            }
            else if (e.getErrorCode() == 1406) {
				showMessageDialog("Acuérdate del límite de caracteres");
            }else if (e.getErrorCode() == 1366) {
				showMessageDialog("Error en tipo de carácter");
			} else {
                System.out.println("Error con el botón de modificar Alumno: "+e.getMessage());
			    showMessageDialog("Hubo un error al cambiar los datos");
            }
			
			// TODO: handle exception
		} catch (Exception e){
            System.out.println("Ocurrió un error inesperado");
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
