package algocraft.construccionesAlternativas;

import Interfaces.Construccion;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import algocraft.exception.RecursosNegativosException;
import stats.Recurso;

public class CreadorEdificiosTerran {

	public boolean puedoCrearEdificio(EnumEdificiosTerran nombreEdificio,
			Recurso recursosDisponible) {
		if(nombreEdificio==EnumEdificiosTerran.CENTRO_DE_MINERALES)
			return this.puedeCrearCentroMineral(recursosDisponible);
		if(nombreEdificio==EnumEdificiosTerran.FABRICA)
			return this.puedeCrearFabrica(recursosDisponible);
		else return false;
	}

	public Construccion crearEdificio(EnumEdificiosTerran nombreEdificio,
			Recurso recursosDisponible) throws RecursosNegativosException{
		
		if(nombreEdificio==EnumEdificiosTerran.CENTRO_DE_MINERALES)
			return this.crearCentroMineral(recursosDisponible);
		return null;//lanzar excepcion?
			
	}
	
	private boolean puedeCrearCentroMineral(Recurso recursosDisponibles){
		final int mineralNecesario=50;
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= mineralNecesario);
		
		return puedeCrearse;

	}

	private Construccion crearCentroMineral(Recurso recursosDisponibles) throws RecursosNegativosException {
		final int mineralNecesario=50;
		if(puedeCrearCentroMineral(recursosDisponibles) ){
			recursosDisponibles.consumirMineral(mineralNecesario);
			return new RecolectorMineral(new EdificioBasico(EnumEdificiosTerran.CENTRO_DE_MINERALES,500,4) );
		}
		else return null;//o lanzar excepcion ya que no pregunto si podia antes
	}
	
	private boolean puedeCrearFabrica(Recurso recursosDisponibles) {
		final int mineralNecesario=200;
		final int gasNecesario=100;
		//final Edificios edificioNecesario=Edificios.BARRACA;
		//no se para que es esta linea pero como no se esta usando
		//la comento para committear sin warnings.
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= mineralNecesario) &&
				(recursosDisponibles.obtenerGas() >= gasNecesario) ;
		
		// verificar dependencia edificios
		
		return puedeCrearse;
	}

}

