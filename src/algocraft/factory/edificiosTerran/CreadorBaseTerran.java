package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorBaseTerran extends EdificiosAbstractFactory {
	
	public CreadorBaseTerran(){
		this.recursosNecesarios = new Recurso(0,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new EdificioBasico(EnumEdificiosTerran.BASE_TERRAN,2500,0);
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
