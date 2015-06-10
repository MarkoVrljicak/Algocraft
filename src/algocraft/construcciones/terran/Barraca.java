package algocraft.construcciones.terran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.terran.UnidadesTerran;

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
		return null;
			
	}	
}
