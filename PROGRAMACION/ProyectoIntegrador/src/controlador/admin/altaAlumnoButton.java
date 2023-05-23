package controlador.admin;
// Imports
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import modelo.AccesoBD;
import vistas.admin.AltaAlumno;
/**
 * Clase del botón para dar alta a un alumno nuevo
 */
public class altaAlumnoButton implements ActionListener {
    private String nombre;
    private String apellido;
    private String nExpendiente;
    private String idProyecto;
    private AltaAlumno ventana;
    private Connection con;
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
        nombre = ventana.getNombre();
        apellido = ventana.getApellido();
        nExpendiente = ventana.getNExpediente();
        idProyecto = ventana.getIdProyecto();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        con = access.getConexion();

		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
			String query = "Insert into Alumno (Nombre, Apellidos, N_expediente, ID_Proyecto) values('"
				+nombre+"','"+apellido+"','"+nExpendiente+"','"+idProyecto+"')";
            statement.executeUpdate(query);
            statement.close();
			con.close();
			showMessageDialog("Se han introducido los datos correctamente");
		} catch (SQLException e) {
			// Cuando da error de las foreign keys
			if (e.getErrorCode() == 1452) {
				showMessageDialog("ID_Proyecto tiene que existir");
			}
			// Cuando se intentan introducir valores más largos de lo permitido
			else if (e.getErrorCode() == 1406) {
				showMessageDialog("Acuérdate del límite de caracteres");
            }
			// Cuando se mete por ejemplo un string en un int
			else if (e.getErrorCode() == 1366) {
				showMessageDialog("Error en tipo de carácter");
			}
			// Otro tipo de errores
			else{
				System.out.println("Error con el botón de alta Alumno: "+e.getMessage());
				showMessageDialog("Hubo un error al introducir los datos");
			}
			
		} catch(Exception e){
			System.out.println("Hubo un error inesperado: "+e.getMessage());
		}
    }
	/**
	 * Método para mostrar un dialog
	 * @param message
	 */
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
