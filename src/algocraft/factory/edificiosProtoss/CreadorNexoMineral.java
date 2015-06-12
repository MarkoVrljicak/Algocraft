package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.NexoMineral;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorNexoMineral extends CreadorDeEdificios {

	public CreadorNexoMineral(){
		this.recursosNecesarios = new Recurso(50,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new NexoMineral();
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
