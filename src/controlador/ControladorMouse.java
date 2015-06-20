package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import visual.VistaTerreno;
import algocraft.Juego;



public class ControladorMouse extends MouseAdapter {

    Juego juego;

    VistaTerreno vista;

    public ControladorMouse(Juego juego, VistaTerreno vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void mousePressed(MouseEvent mouseEvent) {

        // Ojo al piojo.
        // El manejo de las coordenadas del mouse debe ser encapsulado por la clase Posicion
        // modelo.inicializarModeloDato(new Posicion(mouseEvent.getX(), mouseEvent.getY()));
//
//        modelo.inicializarModeloDato(vista.posicion);
    }
}
