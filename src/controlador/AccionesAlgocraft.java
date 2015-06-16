package controlador;

import java.awt.event.ActionListener;

public abstract class AccionesAlgocraft implements ActionListener{

	protected static Controlador controlador;
	
	public static void setearControlador(Controlador miControlador){
		AccionesAlgocraft.controlador = miControlador;
	}
}
