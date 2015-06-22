package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Juego;
import visual.VistaTerreno;


//borrable
public class ControladorMouse extends MouseAdapter {

    Juego juego;

    VistaTerreno vista;

    public ControladorMouse(Juego juego, VistaTerreno vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void mousePressed(MouseEvent mouseEvent) {
     //ofrecer opciones al jugador o acciones, pedirle a la vista su posicion
    //potencialmente aniadir controladores hijos para diferenciar comportamiento suelo de cielo
    	
    }
}
