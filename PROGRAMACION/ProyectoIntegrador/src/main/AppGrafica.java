package main;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

import vistas.VentanaPrincipal;

public class AppGrafica {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.hacerVisible();;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
