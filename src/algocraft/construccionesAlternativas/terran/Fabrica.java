package algocraft.construccionesAlternativas.terran;

import stats.Recurso;
import algocraft.construccionesAlternativas.CreadorDeUnidades;
import algocraft.construccionesAlternativas.EdificioBasico;
import algocraft.construccionesAlternativas.EnumEdificiosTerran;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;
import algocraft.unidades.Alternativas.UnidadesTerran;

public class Fabrica extends CreadorDeUnidades{
	
	private static final EnumEdificiosTerran nombreFabrica = EnumEdificiosTerran.FABRICA;
	private static final UnidadesTerran nombreGolliat= UnidadesTerran.GOLLIAT;
	private static final int vidaGolliat = 125;
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
			return this.crearUnidadEspecifica(nombreGolliat, vidaGolliat, recursosNecesariosGolliat, poblacionNecesariaGolliat);
		return null;
	}

	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
	}	
}
