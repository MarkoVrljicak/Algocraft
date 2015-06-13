package algocraft.factory.edificiosTerran;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.RecolectorGas;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorRefineria extends EdificiosAbstractFactory {

	public CreadorRefineria(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public RecolectorGas crearEdificio() {
		return new RecolectorGas(new EdificioBasico(EnumEdificiosTerran.REFINERIA,750,6));
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return false;
	}

	@Override
	public EnumEdificios getConstruccionNecesitada() {
		return null;
	}
}
