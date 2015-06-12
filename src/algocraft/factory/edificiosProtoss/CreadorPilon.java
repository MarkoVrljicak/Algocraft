package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.Pilon;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorPilon extends CreadorDeEdificios {

	public CreadorPilon(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new Pilon();
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
