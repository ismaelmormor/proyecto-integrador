package controlador;

import vistas.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener{

    private JFrame ventana;

	public MenuListener(JFrame ventana){
        this.ventana=ventana;
	}

    @Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equals("Consulta")) {
				ventana.dispose();
                ConsultaW ventanaNueva = new ConsultaW();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("Alta")){
                ventana.dispose();
                Alta ventanaNueva = new Alta();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("Lista de Alumnos")){
                ventana.dispose();
                ListaDeAlumnos ventanaNueva = new ListaDeAlumnos();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("Añadir")){
                ventana.dispose();
                Add_Alumno ventanaNueva = new Add_Alumno();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("DAW")){
                ventana.dispose();
                DAW ventanaNueva = new DAW();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("DAM")){
                ventana.dispose();
                DAM ventanaNueva = new DAM();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("ASIR")){
                ventana.dispose();
                Asir ventanaNueva = new Asir();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("ANIMACIONES 3D")){
                ventana.dispose();
                Animacion3D ventanaNueva = new Animacion3D();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("VIDEOJUEGOS")){
                ventana.dispose();
                Juegos ventanaNueva = new Juegos();
		        ventanaNueva.setVisible(true);
            }
            
            
		}

	}

}
