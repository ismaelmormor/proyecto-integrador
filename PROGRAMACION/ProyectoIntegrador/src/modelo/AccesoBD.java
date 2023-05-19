package modelo;

import java.sql.*;

public class AccesoBD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/UF7";
	private String usuario = "root";
	private String pword = "SkillMoreno";
	
	public Connection getConexion() {
		Connection con = null;
		try {

			Class.forName(driver);
	        con=DriverManager.getConnection(url,usuario,pword);
	        System.out.println("Conexion perfecta");
            
	    } catch (Exception e) {
	        System.out.println("error al establecer conexión con BD"+ e.getMessage());
	        // TODO: handle exception
	    }
		return con;
	}
	
}
