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
                Alta ventanaNueva = new Alta();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("Lista de Alumnos")){
                ListaDeAlumnos ventanaNueva = new ListaDeAlumnos();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("Añadir")){
                Add_Alumno ventanaNueva = new Add_Alumno();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("DAW")){
                DAW ventanaNueva = new DAW();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("DAM")){
                DAM ventanaNueva = new DAM();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("ASIR")){
                Asir ventanaNueva = new Asir();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("ANIMACIONES 3D")){
                Animacion3D ventanaNueva = new Animacion3D();
		        ventanaNueva.setVisible(true);
            }else if(ev.getActionCommand().equals("VIDEOJUEGOS")){
                Juegos ventanaNueva = new Juegos();
		        ventanaNueva.setVisible(true);
            }
            
            
		}

	}

}
