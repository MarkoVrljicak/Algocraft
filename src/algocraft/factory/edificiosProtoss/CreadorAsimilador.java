package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.Asimilador;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorAsimilador extends CreadorDeEdificios {

	public CreadorAsimilador(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new Asimilador();
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
