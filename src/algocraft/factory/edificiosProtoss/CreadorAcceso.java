package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.Acceso;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorAcceso extends CreadorDeEdificios {

	public CreadorAcceso(){
		this.recursosNecesarios = new Recurso(150,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new Acceso();
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
