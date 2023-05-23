package controlador;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.ListaProyectos;

public class eliminarProyecto implements ActionListener {
    private int id;
    private ListaProyectos ventana;
    private Connection con;

    public eliminarProyecto(ListaProyectos ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // Recolección de datos
        id = ventana.seleccionTabla();
        if (id != -1){
            AccesoBD access = new AccesoBD();
            con = access.getConexion();
            
		    try {
		    	// Preparamos la consulta a la base de datos
		    	Statement statement = con.createStatement();
		    	String query = "DELETE FROM PROYECTO_INTEGRADOR WHERE ID_Proyecto = "+id;
                statement.executeUpdate(query);
                statement.close();
		    	con.close();
		    	showMessageDialog("Se han eliminado los datos correctamente");
                String query2 = "SELECT * FROM PROYECTO_INTEGRADOR";
                ventana.actualizarTabla(query2);
            
		    } catch (SQLException e) {
                System.out.println("Error con el botón de eliminar Proyecto: "+e.getMessage());
		    	showMessageDialog("Hubo un error al cambiar los datos");

		    } catch (Exception e){
                System.out.println("Ocurrió un error inesperado");
            }
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
