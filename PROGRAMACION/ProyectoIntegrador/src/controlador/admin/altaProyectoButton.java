package controlador.admin;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import modelo.AccesoBD;
import vistas.admin.AltaProyecto;

/**
 * Clase del botón para dar alta un proyecto nuevo
 */
public class altaProyectoButton implements ActionListener {
	// Variables
    private String nombre;
    private String curso;
    private String grupo;
    private String year;
    private String link;
    private String nota;
    private String id_area;
    private AltaProyecto ventana;
    private Connection con;
	/**
	 * Método constructor
	 * @param ventana - la ventana desde la que se llama
	 */
    public altaProyectoButton(AltaProyecto ventana) {
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
        curso = ventana.getCurso();
        grupo = ventana.getGrupo();
        year = ventana.getYear();
        link = ventana.getUrl();
        nota = ventana.getNota();
		id_area = ventana.getIDArea();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        con = access.getConexion();

		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
            
            String query = "Insert into Proyecto_Integrador (Nombre, Curso, Grupo, Año, url, nota, id_area) values ('"+
            nombre+"','"+curso+"','"+grupo+"','"+year+"','"+link+"',"+nota+","+ id_area +")";

            statement.executeUpdate(query);
            statement.close();
			con.close();

            showMessageDialog("Datos introducidos correctamente");

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
			else{
				System.out.println("Error con el botón de alta Proyecto: "+e.getMessage());
				showMessageDialog("Hubo un error al introducir los datos");
			}
			
		} catch(Exception e){
			System.out.println("Hubo un error inesperado: "+e.getMessage());
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
