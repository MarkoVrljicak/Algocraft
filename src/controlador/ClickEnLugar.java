package controlador;

import java.awt.event.ActionEvent;

import algocraft.mapa.Coordenada;



public class ClickEnLugar extends AccionesAlgocraft{
	
	private Coordenada posicion;
	
	public ClickEnLugar(int x , int y){
		super();
		posicion = new Coordenada(x,y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controlador.realizarAccionPara(posicion);
	}

}
