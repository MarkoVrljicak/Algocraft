package controlador.acciones;

import java.awt.event.ActionListener;

import controlador.Controlador;

public abstract class AccionesAlgocraft implements ActionListener{

	protected static Controlador controlador;
	
	public static void setearControlador(Controlador miControlador){
		AccionesAlgocraft.controlador = miControlador;
	}
}
