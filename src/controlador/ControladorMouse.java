package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Juego;
import visual.VistaTerreno;


//borrable
public abstract class ControladorMouse extends MouseAdapter {

    Juego juego;

    VistaTerreno vista;

    public ControladorMouse(Juego juego, VistaTerreno vista) {
        this.juego = juego;
        this.vista = vista;
    }

    abstract public void mousePressed(MouseEvent mouseEvent);
}
