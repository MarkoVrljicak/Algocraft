package controlador.strategiesClick;

import controlador.Controlador;
import modelo.Juego;
import modelo.unidades.UnidadAtacante;
import visual.Seleccionable;

public class StrategyAtacar implements StrategyAccion {

	private UnidadAtacante unidad;

	public StrategyAtacar(UnidadAtacante unidad) {
		this.unidad = unidad;
	}

	@Override
	public void accionPara(Seleccionable accionado, Juego juego ,Controlador controlador) {
		controlador.realizarAtaque(unidad,accionado);		
	}

}
