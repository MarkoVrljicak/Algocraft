package algocraft.construccionesAlternativas;

import stats.Recurso;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public class Barraca extends CreadorDeUnidades {
	
	private static final Edificios nombreBarraca = Edificios.BARRACA;
	private static final Unidades nombreMarine= Unidades.MARINE;
	private static final int vidaMarine=40;

	public Barraca() {
		super(new EdificioBasico(nombreBarraca,1000,12));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreMarine)	;
	}
	
	@Override
	public boolean puedoCrearUnidad(Unidades nombreUnidad,
			Recurso recursosDisponible, int poblacionDisponible) {
		if(nombreUnidad==nombreMarine)
			return this.puedeCrearMarine(recursosDisponible, poblacionDisponible);
		else return false;
	}

	public Unidad crearUnidad(Unidades nombreUnidad,
			Recurso recursosDisponible,int poblacionDisponible){
		
		if(nombreUnidad==nombreMarine)
			return this.crearMarine(recursosDisponible, poblacionDisponible);
		return null;//lanzar excepcion?
			
	}
	
	private boolean puedeCrearMarine(Recurso recursosDisponibles,int poblacionDisponible){
		final int mineralNecesario=50;
		final int poblacionNecesaria= 1;
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= mineralNecesario);
		puedeCrearse = puedeCrearse && (poblacionDisponible >= poblacionNecesaria);
		
		return puedeCrearse;

	}

	private Unidad crearMarine(Recurso recursosDisponibles,int poblacionDisponible) {
		final int mineralNecesario=50;
		if(puedeCrearMarine(recursosDisponibles, poblacionDisponible) ){
			try {
				recursosDisponibles.consumirMineral(mineralNecesario);
			} catch (RecursosNegativosException e) {
				e.printStackTrace();
			}
			return new Unidad(nombreMarine,vidaMarine);
		}
		else return null;//o lanzar excepcion ya que no pregunto si podia antes
	}

	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
	}	
}
