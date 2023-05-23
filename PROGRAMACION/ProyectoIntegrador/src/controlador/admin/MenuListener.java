package controlador.admin;
// Import de todo
import vistas.admin.AltaAlumno;
import vistas.admin.AltaProyecto;
import vistas.admin.Animacion3D;
import vistas.admin.Asir;
import vistas.admin.DAM;
import vistas.admin.DAW;
import vistas.admin.Juegos;
import vistas.admin.ListaDeAlumnos;
import vistas.admin.ListaProyectos;

import javax.swing.*;
import java.awt.event.*;
/*
 * Clase del listener que hace funcionar el menú de cada ventana
 */
public class MenuListener implements ActionListener{
    // Variables
    private JFrame ventana;

    /* 
     * Método constructor
     * @param ventana - JFrame de la ventana desde donde se acciona el Listener
     */
	public MenuListener(JFrame ventana){
        this.ventana=ventana;
	}

    @Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JMenuItem) {
            // ActionListener para el apartado de Consulta de Proyecto Integrador
			if (ev.getActionCommand().equals("Consulta")) {
                //Cerramos ventana y creamos la de consulta
				ventana.dispose();
                ListaProyectos ventanaNueva = new ListaProyectos();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Alta de Proyecto Integrador
            else if(ev.getActionCommand().equals("Alta")){
                //Cerramos ventana y creamos la de Alta
                ventana.dispose();
                AltaProyecto ventanaNueva = new AltaProyecto();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Lista de Alumnos
            else if(ev.getActionCommand().equals("Lista de Alumnos")){
                //Cerramos ventana y creamos la de Lista de ALumno
                ventana.dispose();
                ListaDeAlumnos ventanaNueva = new ListaDeAlumnos();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Añadir Alumnos
            else if(ev.getActionCommand().equals("Añadir")){
                //Cerramos ventana y creamos la de añadir Alumno
                ventana.dispose();
                AltaAlumno ventanaNueva = new AltaAlumno();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de DAW
            else if(ev.getActionCommand().equals("DAW")){
                //Cerramos ventana y creamos la de DAW
                ventana.dispose();
                DAW ventanaNueva = new DAW();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de DAM
            else if(ev.getActionCommand().equals("DAM")){
                //Cerramos ventana y creamos la de DAM
                ventana.dispose();
                DAM ventanaNueva = new DAM();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Asir
            else if(ev.getActionCommand().equals("ASIR")){
                //Cerramos ventana y creamos la de Asir
                ventana.dispose();
                Asir ventanaNueva = new Asir();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Animaciones 3D
            else if(ev.getActionCommand().equals("ANIMACIONES 3D")){
                //Cerramos ventana y creamos la de Animaciones 3D
                ventana.dispose();
                Animacion3D ventanaNueva = new Animacion3D();
		        ventanaNueva.setVisible(true);
            }
            // ActionListener para el apartado de Videjuegos
            else if(ev.getActionCommand().equals("VIDEOJUEGOS")){
                //Cerramos ventana y creamos la de videojuegos
                ventana.dispose();
                Juegos ventanaNueva = new Juegos();
		        ventanaNueva.setVisible(true);
            }
		}
	}
}