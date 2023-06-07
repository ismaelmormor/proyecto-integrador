package modelo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
/**
 * Clase para realizar la conexión con la base de datos
 */
public class AccesoBD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/ProyectoIntegrador";
	private String usuario = "root";
	private String pword = "SkillMoreno";
	private Connection con;
	private JFrame ventana;
	/**
	 * Método para obtener la conexión
	 * @return con - Devuelve la conexión con la base de datos
	 */
	public Connection getConexion() {
		con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, pword);
			System.out.println("Conexion perfecta");

		} catch (Exception e) {
			System.out.println("error al establecer conexión con BD" + e.getMessage());
		}
		return con;
	}


	public void altaAlumno(Alumno a, JFrame v){
		con = getConexion();
		ventana = v;

		try {
			Statement statement = con.createStatement();
			String query = "Insert into Alumno (Nombre, Apellidos, N_expediente, ID_Proyecto) values('"
					+a.getNombre()+"','"+a.getApellidos()+"','"+a.getnExpediente()+"','"+a.getIdProyecto()+"')";
			statement.executeUpdate(query);
			statement.close();
			con.close();
			showMessageDialog("Alumno añadido con éxito");
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
			// Otro tipo de errores
			else{
				System.out.println("Error con el botón de alta Alumno: "+e.getMessage());
				showMessageDialog("Hubo un error al introducir los datos");
			}
			
		} catch(Exception e){
			System.out.println("Hubo un error inesperado: "+e.getMessage());
		}
    }
	
	public void altaProyecto(Proyecto p, JFrame v){
		con = getConexion();
		ventana = v;
		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
            
            String query = "Insert into Proyecto_Integrador (Nombre, Curso, Grupo, Año, url, nota, id_area) values ('"+
            p.getNombre()+"','"+p.getCurso()+"','"+p.getGrupo()+"','"+p.getYear()+"','"+p.getUrl()+"',"+p.getNota()+","+ p.getIdArea() +")";

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


	/**
	 * Método para mostrar un dialog
	 * @param message
	 */
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
