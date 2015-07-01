package controlador;

import modelo.Juego;
import modelo.unidades.protos.AltoTemplario;
import visual.Seleccionable;

public class StrategyTormentaPsionica implements StrategyAccion {

	private AltoTemplario altoTemplario;

	public StrategyTormentaPsionica(AltoTemplario altoTemplario) {
		this.altoTemplario = altoTemplario;
	}
	
	@Override
	public void accionPara(Seleccionable accionado, Juego juego,
			Controlador controlador) {
		controlador.realizarTormentaPsionica(altoTemplario,accionado.obtenerPosicion());		

	}

}
