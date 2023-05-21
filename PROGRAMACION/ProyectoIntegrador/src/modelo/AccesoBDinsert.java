package modelo;

import java.sql.*;
//para insertar los datos de la vista alta al BD.
public class AccesoBDinsert {
    private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/UF7";
	private String usuario = "root";
	private String pword = "root";

	public Connection getConexion(String nombre,String curso,String grupo,String año,String link,String nota) {
		Connection con = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, pword);
			Statement st=con.createStatement();
            st.executeUpdate("insert into Proyecto_Integrador values('"+nombre+"','"+curso+"','"+grupo+"','"+año+"','"+link+"','"+nota+"')");
            st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("error al establecer conexión con BD" + e.getMessage());
			// TODO: handle exception
		}
		return con;
	}

}
