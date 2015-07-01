package controlador.strategiesClick;

import modelo.Juego;
import modelo.unidades.Unidad;
import modelo.unidades.protos.AltoTemplario;
import visual.Seleccionable;
import controlador.Controlador;

public class StrategyAlucinacion implements StrategyAccion {

	private AltoTemplario altoTemplario;

	public StrategyAlucinacion(AltoTemplario altoTemplario) {
		this.altoTemplario = altoTemplario;
	}

	@Override
	public void accionPara(Seleccionable accionado, Juego juego ,Controlador controlador) {
		controlador.realizarAlucinacion(altoTemplario, (Unidad) accionado.getDaniable(), accionado.obtenerPosicion());		
	}

}
