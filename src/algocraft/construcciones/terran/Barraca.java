package algocraft.construcciones.terran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.terran.UnidadesTerran;

public class Barraca extends CreadorDeUnidades {
	
	
	private static final Recurso recursosNecesariosMarine = new Recurso(50,0);
	private static final int poblacionNecesariaMarine = 1;
	private static Recurso recursosNecesarios = new Recurso(150,0);

	public Barraca() {
		super(new EdificioBasico(EnumEdificiosTerran.BARRACA,1000,12));
	}
	
	@Override
	protected void determinarCreables() {
		this.aniadirUnidadCreable(UnidadesTerran.MARINE)	;
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==UnidadesTerran.MARINE)
			return this.crearUnidadEspecifica(UnidadesTerran.MARINE,
					recursosNecesariosMarine, poblacionNecesariaMarine);
		return null;
			
	}

	public static Recurso getRecursosNecesarios() {
		return recursosNecesarios;
	}
	
}
