package controlador;

import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.AltaProyecto;

public class altaProyectoButton implements ActionListener {
    private String nombre;
    private String curso;
    private String grupo;
    private String year;
    private String link;
    private String nota;
    private String id_area;
    private AltaProyecto ventana;
    private Connection con;

    public altaProyectoButton(AltaProyecto ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Recolección de datos
        nombre = ventana.getNombre();
        curso = ventana.getCurso();
        grupo = ventana.getGrupo();
        year = ventana.getYear();
        link = ventana.getUrl();
        nota = ventana.getNota();
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

		} catch (Exception e) {
			System.out.println("Error en el botón altaProyecto"+e.getMessage());
			// TODO: handle exception
		}
    }
}
