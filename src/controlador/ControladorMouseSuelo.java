package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import visual.VistaTerreno;
import algocraft.Juego;
//borrable
public class ControladorMouseSuelo extends MouseAdapter {

	Juego juego;

    VistaTerreno vista;

    public ControladorMouseSuelo(Juego juego, VistaTerreno vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void mousePressed(MouseEvent mouseEvent) {
    	vista.accionDePruebaSuelo();
    }

}
