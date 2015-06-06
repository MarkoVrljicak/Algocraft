package algocraft.construccionesAlternativas;

import stats.Recurso;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public class Barraca extends CreadorDeUnidades {
	
	private static final Edificios nombreBarraca = Edificios.BARRACA;
	private static final Unidades nombreMarine= Unidades.MARINE;
	private static final int vidaMarine=40;
	private static final Recurso recursosNecesariosMarine = new Recurso(50,0);
	private static final int poblacionNecesariaMarine = 1;

	public Barraca() {
		super(new EdificioBasico(nombreBarraca,1000,12));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreMarine)	;
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreMarine)
			return this.crearUnidadEspecifica(nombreMarine, vidaMarine, recursosNecesariosMarine, poblacionNecesariaMarine);
		return null;//lanzar excepcion?
			
	}
	
	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
	}	
}
