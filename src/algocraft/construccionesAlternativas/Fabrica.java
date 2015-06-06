package algocraft.construccionesAlternativas;

import stats.Recurso;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public class Fabrica extends CreadorDeUnidades{
	
	private static final Edificios nombreFabrica = Edificios.FABRICA;
	private static final Unidades nombreGolliat= Unidades.GOLLIAT;
	private static final int vidaGolliat = 125;
	private static final Recurso recursosNecesariosGolliat = new Recurso(100,50);
	private static final int poblacionNecesariaGolliat = 2;

	
	public Fabrica() {
		super(new EdificioBasico(nombreFabrica,1000,12));
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
