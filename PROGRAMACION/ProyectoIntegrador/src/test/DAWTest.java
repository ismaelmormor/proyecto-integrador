package test;

import org.junit.jupiter.api.Test;

import vistas.alumno.DAWA;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import static org.junit.jupiter.api.Assertions.*;

class DAWTest {

    @Test
    void testMenuItems() {
        // Creamos una instancia de la clase DAW
        DAWA daw = new DAWA();

        // Obtenemos la barra de menú de la instancia de DAW
        JMenuBar menuBar = daw.getJMenuBar();
        assertNotNull(menuBar); // Verificamos que la barra de menú no sea nula

        // Buscamos el menú "P.I." en la barra de menú
        JMenu piMenu = findMenu(menuBar, "P.I.");
        assertNotNull(piMenu); // Verificamos que el menú "P.I." no sea nulo

        // Buscamos el elemento "Consulta" dentro del menú "P.I."
        JMenuItem consultaItem = findMenuItem(piMenu, "Consulta");
        assertNotNull(consultaItem); // Verificamos que el elemento "Consulta" no sea nulo
    }

    // Método auxiliar para buscar un menú por su nombre en una barra de menú
    private JMenu findMenu(JMenuBar menuBar, String menuName) {
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            JMenu menu = menuBar.getMenu(i);
            if (menu.getText().equals(menuName)) {
                return menu;
            }
        }
        return null; // Si no se encuentra el menú, se retorna null
    }

    // Método auxiliar para buscar un elemento de menú por su nombre en un menú
    private JMenuItem findMenuItem(JMenu menu, String itemName) {
        for (int i = 0; i < menu.getItemCount(); i++) {
            JMenuItem menuItem = menu.getItem(i);
            if (menuItem.getText().equals(itemName)) {
                return menuItem;
            }
        }
        return null; // Si no se encuentra el elemento de menú, se retorna null
    }
}
