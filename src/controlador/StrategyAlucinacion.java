package controlador;

import modelo.Juego;
import modelo.unidades.protos.AltoTemplario;
import visual.Seleccionable;

public class StrategyAlucinacion implements StrategyAccion {

	private AltoTemplario altoTemplario;

	public StrategyAlucinacion(AltoTemplario altoTemplario) {
		this.altoTemplario = altoTemplario;
	}

	@Override
	public void accionPara(Seleccionable accionado, Juego juego ,Controlador controlador) {
		controlador.realizarAlucinacion(altoTemplario, accionado, accionado.obtenerPosicion());		
	}

}
