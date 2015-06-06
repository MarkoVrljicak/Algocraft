package algocraft.construccionesAlternativas;

import stats.Recurso;
import algocraft.exception.RecursosNegativosException;
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
			return this.crearMarine();
		return null;//lanzar excepcion?
			
	}
	
	private Unidad crearMarine() {
		if(puedoCrearUnidad(recursosNecesariosMarine, poblacionNecesariaMarine) ){
			
			try {
				this.getDuenio().getRecursos().consumirMineral(recursosNecesariosMarine.obtenerMineral());
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
