package controlador;

import java.awt.event.MouseAdapter;

public abstract class MiControladorMouse extends MouseAdapter {

	protected static Controlador controlador;
	
	public static void setearControlador(Controlador miControlador){
		controlador = miControlador;
	}
}
