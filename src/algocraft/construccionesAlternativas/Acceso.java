package algocraft.construccionesAlternativas;

import stats.Recurso;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;
import algocraft.unidades.Alternativas.UnidadesProtos;

public class Acceso extends CreadorDeUnidades {
	
	private static final EdificiosProtos nombreAcceso = EdificiosProtos.ACCESO;
	private static final UnidadesProtos nombreZealot= UnidadesProtos.ZEALOT;
	private static final int vidaZealot = 100;
	private static final Recurso recursosNecesariosZealot = new Recurso(100,0);
	private static final int poblacionNecesariaZealot = 2;

	public Acceso() {
		super(new EdificioConEscudo(nombreAcceso,500,12,500));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreZealot)	;
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreZealot)
			return this.crearUnidadEspecifica(nombreZealot, vidaZealot, recursosNecesariosZealot, poblacionNecesariaZealot);
		return null;//lanzar excepcion?
			
	}
	
	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
	}	

}
