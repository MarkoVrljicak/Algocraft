package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.terran.Barraca;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorBarraca extends CreadorDeEdificios {

	public CreadorBarraca(){
		this.recursosNecesarios = new Recurso(150,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new Barraca();
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
