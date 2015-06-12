package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.BaseProtoss;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorBaseProtoss extends CreadorDeEdificios {

	public CreadorBaseProtoss(){
		this.recursosNecesarios = new Recurso(0,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new BaseProtoss();
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
