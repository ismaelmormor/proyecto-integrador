package test;

import org.junit.jupiter.api.Test;

import vistas.VentanaPrincipal;

import static org.junit.jupiter.api.Assertions.*;

class VentanaPrincipalTest {

    @Test
    void hacerVisible() {
        VentanaPrincipal ventana = new VentanaPrincipal();

        // Verificar que la ventana inicialmente no está visible
        assertFalse(ventana.isVisible());

        // Hacer visible la ventana
        ventana.hacerVisible();

        // Verificar que la ventana ahora está visible
        assertTrue(ventana.isVisible());
    }
}