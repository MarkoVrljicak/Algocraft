package algocraft.construcciones.terran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.terran.UnidadesTerran;

public class Fabrica extends CreadorDeUnidades{
	
	private static final EnumEdificiosTerran nombreFabrica = EnumEdificiosTerran.FABRICA;
	private static final UnidadesTerran nombreGolliat= UnidadesTerran.GOLLIAT;
	private static final Recurso recursosNecesariosGolliat = new Recurso(100,50);
	private static final int poblacionNecesariaGolliat = 2;

	
	public Fabrica() {
		super(new EdificioBasico(nombreFabrica,1250,12));
	}

	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreGolliat);
	}

	@Override
	public Unidad crearUnidad(Unidades nombreUnidad) {
		if(nombreUnidad==nombreGolliat)
			return this.crearUnidadEspecifica(nombreGolliat, recursosNecesariosGolliat, poblacionNecesariaGolliat);
		return null;
	}	
}
