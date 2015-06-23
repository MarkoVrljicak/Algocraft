package controlador;

import java.awt.event.MouseEvent;

import modelo.exception.FueraDeLimitesException;
import modelo.mapa.Coordenada;
import visual.VistaTerreno;

public class ControladorMouseCielo extends MiControladorMouse {

	Coordenada posicion;

    public ControladorMouseCielo(VistaTerreno vista) {
        this.posicion = vista.getPosicion();
    }

    public void mousePressed(MouseEvent mouseEvent) {
    	try {
			controlador.accionCielo(posicion);
		} catch (FueraDeLimitesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
