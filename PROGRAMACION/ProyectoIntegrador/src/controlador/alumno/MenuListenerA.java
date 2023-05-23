package controlador.alumno;
// Import de todo
import vistas.admin.VentanaLogin;
import vistas.alumno.Animacion3DA;
import vistas.alumno.AsirA;
import vistas.alumno.DAMA;
import vistas.alumno.DAWA;
import vistas.alumno.JuegosA;
import vistas.alumno.ListaVAlumnos;
import vistas.alumno.ListaVProyectos;

import javax.swing.*;
import java.awt.event.*;
/*
 * Clase del listener que hace funcionar el menú de cada ventana
 */
public class MenuListenerA implements ActionListener{
    // Variables
    private JFrame ventana;

    /* 
     * Método constructor
     * @param ventana - JFrame de la ventana desde donde se acciona el Listener
     */
	public MenuListenerA(JFrame ventana){
        this.ventana=ventana;
	}

    @Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JMenuItem) {
            // ActionListener para el apartado de Consulta de Proyecto Integrador
			if (ev.getActionCommand().equals("Consulta")) {
                //Cerramos ventana y creamos la de consulta
				ventana.dispose();
                ListaVProyectos ventanaNueva = new ListaVProyectos();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Lista de Alumnos
            else if(ev.getActionCommand().equals("Lista de Alumnos")){
                //Cerramos ventana y creamos la de Lista de ALumno
                ventana.dispose();
                ListaVAlumnos ventanaNueva = new ListaVAlumnos();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de DAW
            else if(ev.getActionCommand().equals("DAW")){
                //Cerramos ventana y creamos la de DAW
                ventana.dispose();
                DAWA ventanaNueva = new DAWA();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de DAM
            else if(ev.getActionCommand().equals("DAM")){
                //Cerramos ventana y creamos la de DAM
                ventana.dispose();
                DAMA ventanaNueva = new DAMA();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Asir
            else if(ev.getActionCommand().equals("ASIR")){
                //Cerramos ventana y creamos la de Asir
                ventana.dispose();
                AsirA ventanaNueva = new AsirA();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Animaciones 3D
            else if(ev.getActionCommand().equals("ANIMACIONES 3D")){
                //Cerramos ventana y creamos la de Animaciones 3D
                ventana.dispose();
                Animacion3DA ventanaNueva = new Animacion3DA();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Videjuegos
            else if(ev.getActionCommand().equals("VIDEOJUEGOS")){
                //Cerramos ventana y creamos la de videojuegos
                ventana.dispose();
                JuegosA ventanaNueva = new JuegosA();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Login
            else if(ev.getActionCommand().equals("Admin")){
                //Cerramos ventana y creamos la de videojuegos
                ventana.dispose();
                VentanaLogin ventanaNueva = new VentanaLogin();
		        ventanaNueva.setVisible(true);
            }
		}
	}
}