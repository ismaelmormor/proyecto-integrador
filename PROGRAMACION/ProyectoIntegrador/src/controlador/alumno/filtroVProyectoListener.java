package controlador.alumno;

import java.awt.*;
import java.awt.event.*;

import vistas.alumno.ListaVProyectos;

public class filtroVProyectoListener implements ActionListener {
    private String nombre;
    private String curso;
    private String grupo;
    private String year;
    private String nota;
    private String id_area;
    private String idProyecto;
    private ListaVProyectos ventana;

    public filtroVProyectoListener(ListaVProyectos ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        idProyecto = ventana.getProyecto();
        nombre = ventana.getNombre();
        curso = ventana.getCurso();
        grupo = ventana.getGrupo();
		year = ventana.getYear();
		nota = ventana.getNota();
		id_area = ventana.getArea();

        Boolean primeraCond = true;
		try {
			// Preparamos la consulta a la base de datos
            String query = "SELECT * FROM PROYECTO_INTEGRADOR Where ";
            if (!nombre.isEmpty()){
                if(primeraCond){
                    query += "Nombre = '"+nombre+"'";
                    primeraCond=false;
                }else{
                    query += "AND Nombre = '"+nombre+"'";
                }
            }
            if (!curso.isEmpty()){
                if(primeraCond){
                    query += "Curso = '"+curso+"'";
                    primeraCond=false;
                }else{
                    query += "AND Curso = '"+curso+"'";
                }
            }
            if (!grupo.isEmpty()){
                if(primeraCond){
                    query += "Grupo = '"+grupo+"'";
                    primeraCond=false;
                }else{
                    query += "AND Grupo = '"+grupo+"'";
                }
            }
            if (!year.isEmpty()){
                if(primeraCond){
                    query += "Año = '"+year+"'";
                    primeraCond=false;
                }else{
                    query += "AND Año = '"+year+"'";
                }
            }
            if (!nota.isEmpty()){
                if(primeraCond){
                    query += "Nota = "+nota;
                    primeraCond=false;
                }else{
                    query += " AND Nota = "+nota;
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
            if (!id_area.isEmpty()){
                if(primeraCond){
                    query += "id_area = "+id_area;
                    primeraCond=false;
                }else{
                    query += " AND id_area = "+id_area;
                }
            }
            if (idProyecto.isEmpty() && nombre.isEmpty() && curso.isEmpty() && grupo.isEmpty() && year.isEmpty() && nota.isEmpty() && id_area.isEmpty()){
                query="Select * from PROYECTO_INTEGRADOR";
            }
            ventana.actualizarTabla(query);
			
		} catch (Exception e) {
			System.out.println("Error con el botón de alta Alumno: "+e.getMessage());
			showMessageDialog("Hubo un error al introducir los datos");
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
