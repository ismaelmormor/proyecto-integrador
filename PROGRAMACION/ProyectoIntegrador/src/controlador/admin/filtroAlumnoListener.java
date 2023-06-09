package controlador.admin;

import java.awt.*;
import java.awt.event.*;
import vistas.admin.ListaDeAlumnos;
/**
 * Clase para el filtro de la lista de alumnos
 */
public class filtroAlumnoListener implements ActionListener {
    // Variables
    private String nombre;
    private String apellido;
    private String nExpendiente;
    private String idProyecto;
    private ListaDeAlumnos ventana;
    /**
     * Método constructor
     * @param ventana - la ventana desde donde se llama
     */
    public filtroAlumnoListener(ListaDeAlumnos ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        nombre = ventana.getNombre();
        apellido = ventana.getApellidos();
        nExpendiente = ventana.getNExpediente();
        idProyecto = ventana.getIDProyecto();
        // Boolean para saber si ya se puso una sentencia, y así aplicar el AND
        Boolean primeraCond = true;
		try {
			// Preparamos la consulta a la base de datos
            String query = "SELECT * FROM Alumno Where ";
            // Comprobamos cuales fueron los filtros usados
            if (!nombre.isEmpty()){
                if(primeraCond){
                    query += "Nombre = '"+nombre+"'";
                    primeraCond=false;
                }else{
                    query += "AND Nombre = '"+nombre+"'";
                }
            }
            if (!apellido.isEmpty()){
                if(primeraCond){
                    query += "Apellidos = '"+apellido+"'";
                    primeraCond=false;
                }else{
                    query += "AND Apellidos = '"+apellido+"'";
                }
            }
            if (!nExpendiente.isEmpty()){
                if(primeraCond){
                    query += "N_Expediente = "+nExpendiente+"";
                    primeraCond=false;
                }else{
                    query += " AND N_Expediente = "+nExpendiente+"";
                }
            }
            if (!idProyecto.isEmpty()){
                if(primeraCond){
                    query += "ID_Proyecto = "+idProyecto;
                    primeraCond=false;
                }else{
                    query += " AND ID_Proyecto = "+idProyecto;
                }
            }
            // Si no se puso nada en filtros, hacemos la consulta normal
            if (idProyecto.isEmpty() && nExpendiente.isEmpty() && apellido.isEmpty() && nombre.isEmpty()){
                query="Select * from Alumno";
            }
            // Le mandamos a la tabla el filtro
            ventana.actualizarTabla(query);
			
		} catch (Exception e) {
			System.out.println("Error con el botón de alta Alumno: "+e.getMessage());
			showMessageDialog("Hubo un error al introducir los datos");

		}
    }
    /**
     * Métodod para crear y mostrar el dialog de la notificacion
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
