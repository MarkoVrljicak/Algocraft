package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import visual.Seleccionable;

public class MiControladorMouse extends MouseAdapter {

	private static Controlador controlador;
	private Seleccionable accionado;
	
	public static void setearControlador(Controlador miControlador){
		controlador = miControlador;
	}
	
	public MiControladorMouse(Seleccionable accionado){
		this.accionado = accionado;
	}
	
	public void mousePressed(MouseEvent mouseEvent) {
		controlador.accionPara(accionado);
	}
}
