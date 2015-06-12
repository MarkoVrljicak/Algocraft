package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.terran.Refineria;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorRefineria extends CreadorDeEdificios {

	public CreadorRefineria(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new Refineria();
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
