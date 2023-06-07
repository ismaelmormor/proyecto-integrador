package modelo;

import java.sql.*;
/**
 * Clase para realizar la conexión con la base de datos
 */
public class AccesoBD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/ProyectoIntegrador";
	private String usuario = "root";
	private String pword = "SkillMoreno";
	/**
	 * Método para obtener la conexión
	 * @return con - Devuelve la conexión con la base de datos
	 */
	public Connection getConexion() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, pword);
			System.out.println("Conexion perfecta");

		} catch (Exception e) {
			System.out.println("error al establecer conexión con BD" + e.getMessage());
		}
		return con;
	}

}
