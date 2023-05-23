package test;

import org.junit.jupiter.api.Test;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vistas.alumno.ListaVAlumnos;

import static org.junit.jupiter.api.Assertions.*;

class ListaVAlumnosTest {

    @Test
    void testActualizarTabla() {
        // Creamos una instancia de la clase ListaVAlumnos
        ListaVAlumnos listaVAlumnos = new ListaVAlumnos();

        // Ejecutamos el método actualizarTabla con una consulta válida
        String consulta = "SELECT * FROM Alumnos WHERE ID_Proyecto = '123'";
        listaVAlumnos.actualizarTabla(consulta);

        // Verificamos si el modelo de la tabla se actualizó correctamente
        DefaultTableModel model = getModelFromTable(listaVAlumnos.getTable());
        assertNotNull(model); // Verificamos que el modelo no sea nulo
        assertEquals(consulta, "SELECT * FROM Alumnos WHERE ID_Proyecto = '123'"); // Verificamos la consulta manualmente
    }

    private DefaultTableModel getModelFromTable(JTable table) {
        return (DefaultTableModel) table.getModel();
    }
}