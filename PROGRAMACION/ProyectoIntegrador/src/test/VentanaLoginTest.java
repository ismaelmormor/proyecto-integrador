package test;

import org.junit.jupiter.api.Test;

import vistas.admin.VentanaLogin;

import static org.junit.jupiter.api.Assertions.*;

class VentanaLoginTest {

    @Test
    void getUser() {
        VentanaLogin ventana = new VentanaLogin();

        // Establecer un valor en el campo de usuario
        ventana.textField.setText("usuario123");

        // Obtener el valor del campo de usuario y verificar que coincide
        assertEquals("usuario123", ventana.getUser());
    }

    @Test
    void getPassword() {
        VentanaLogin ventana = new VentanaLogin();

        // Establecer un valor en el campo de contraseña
        ventana.passwordField.setText("contraseña123");

        // Obtener el valor del campo de contraseña y verificar que coincide
        assertEquals("contraseña123", ventana.getPassword());
    }
}