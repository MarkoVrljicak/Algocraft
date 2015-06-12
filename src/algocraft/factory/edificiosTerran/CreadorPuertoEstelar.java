package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.EnumEdificiosTerran;
import algocraft.construcciones.terran.PuertoEstelar;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorPuertoEstelar extends CreadorDeEdificios {

	private EnumEdificiosTerran construccionNecesitada;

	public CreadorPuertoEstelar(){
		this.recursosNecesarios = new Recurso(150,100);
		this.construccionNecesitada = EnumEdificiosTerran.FABRICA;
	}
	
	@Override
	public Construccion crearEdificio() {
		return new PuertoEstelar();
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}

	public EnumEdificiosTerran getConstruccionNecesitada(){
		return construccionNecesitada;
	}
}
