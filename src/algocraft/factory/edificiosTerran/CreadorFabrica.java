package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.EnumEdificiosTerran;
import algocraft.construcciones.terran.Fabrica;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorFabrica extends CreadorDeEdificios {

	private EnumEdificiosTerran construccionNecesitada;

	public CreadorFabrica(){
		this.recursosNecesarios = new Recurso(200,100);
		this.construccionNecesitada = EnumEdificiosTerran.BARRACA;
	}
	
	@Override
	public Construccion crearEdificio() {
		return new Fabrica();
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}

	public EnumEdificiosTerran getConstruccionNecesitada(){
		return construccionNecesitada;
	}
}
