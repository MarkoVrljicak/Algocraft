package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.terran.BaseTerran;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorBaseTerran extends CreadorDeEdificios {
	
	public CreadorBaseTerran(){
		this.recursosNecesarios = new Recurso(0,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new BaseTerran();
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
