package algocraft.construccionesAlternativas.terran;

import stats.Recurso;
import algocraft.construccionesAlternativas.CreadorDeUnidades;
import algocraft.construccionesAlternativas.EdificioBasico;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;
import algocraft.unidades.Alternativas.terran.UnidadesTerran;

public class Barraca extends CreadorDeUnidades {
	
	private static final EnumEdificiosTerran nombreBarraca = EnumEdificiosTerran.BARRACA;
	private static final UnidadesTerran nombreMarine= UnidadesTerran.MARINE;
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
			return this.crearUnidadEspecifica(nombreMarine, recursosNecesariosMarine, poblacionNecesariaMarine);
		return null;//lanzar excepcion?
			
	}	
}
