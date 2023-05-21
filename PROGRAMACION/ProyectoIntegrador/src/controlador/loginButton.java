package controlador;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import modelo.AccesoBD;
import vistas.VentanaLogin;
import vistas.VentanaPrincipal;

public class loginButton implements ActionListener {
    private String usr;
    private String pword;
    private VentanaLogin ventana;
    private Connection con;

    public loginButton(VentanaLogin ventana) {
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Recolección de datos
        usr = ventana.getUser();
        pword = ventana.getPassword();
        // Conexión con BBDD
        AccesoBD access = new AccesoBD();
        con = access.getConexion();

		try {
			// Preparamos la consulta a la base de datos
			Statement statement = con.createStatement();
			String query = "select * from USUARIOS where usuario ='" + usr + "';";
			ResultSet result = statement.executeQuery(query);
			// Si hay resultado (ha encontrado al usuario):
			if (result.next()) {
				// Almacenamos la contraseña en un string para comprobarla posteriormente
				String contraseniaAlmacenada = result.getString("PWORD");
				// Si es igual a la que puso el usuario en el login:
				if (pword.equals(contraseniaAlmacenada)) {
					// Se cierra esta ventana y sale el dialog de Acceso conseguido
					ventana.dispose();
					showMessageDialog("Acceso conseguido");
					// Abrimos la vista de admin
					VentanaPrincipal vAdmin = new VentanaPrincipal();
					vAdmin.setVisible(true);
				} else {
					showMessageDialog("Contraseña no válida");
				}
			} else {
				showMessageDialog("Usuario no encontrado");
			}

			statement.close();
			result.close();

		} catch (Exception e) {
			System.out.println("Error en el botón login");
			// TODO: handle exception
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
