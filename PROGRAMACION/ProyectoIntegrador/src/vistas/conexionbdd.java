package vistas;

import java.sql.*;
public class conexionbdd {
    private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost/login";//hay q cambio dirección de base de datos
	private String usuario="root";
	private String pword="root";
	
	public boolean getConexion(String username,String password) {
		Connection con=null;
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url, usuario, pword);
			String query="select password from usuarios where usuario=?";//tmb modifica query
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1,username);
			ResultSet rset=pstmt.executeQuery();
			if (rset.next()) {
				String pwordLogin=rset.getString("password");
				return password.equals(pwordLogin);
			}
			rset.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al establecer conexión con BD");
			e.printStackTrace();
		}
		return false;
	}
}
