package controlador.alumno;

import java.awt.*;
import java.awt.event.*;

import vistas.alumno.ListaVAlumnos;
/**
 * Clase para el filtro de la lista de alumnos en la vista para alumnos
 */
public class filtroVAlumnoListener implements ActionListener {
    // Variables
    private String nombre;
    private String apellido;
    private String nExpendiente;
    private String idProyecto;
    private ListaVAlumnos ventana;
    /**
     * Método constructor
     * @param ventana - la ventana desde donde se llama
     */
    public filtroVAlumnoListener(ListaVAlumnos ventana) {
        this.ventana=ventana;
    }
    /**
     * Método que se llama al pulsar el botón
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        nombre = ventana.getNombre();
        apellido = ventana.getApellidos();
        nExpendiente = ventana.getNExpediente();
        idProyecto = ventana.getIDProyecto();
        Boolean primeraCond = true;
		try {
			// Preparamos la consulta a la base de datos
            String query = "SELECT * FROM Alumno Where ";
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
            if (idProyecto.isEmpty() && nExpendiente.isEmpty() && apellido.isEmpty() && nombre.isEmpty()){
                query="Select * from Alumno";
            }
            ventana.actualizarTabla(query);
			
		} catch (Exception e) {
			System.out.println("Error con el botón de alta Alumno: "+e.getMessage());
			showMessageDialog("Hubo un error al introducir los datos");
		}
    }
    /**
     * Método para la creación y muestra del dialog de las notificaciones
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
