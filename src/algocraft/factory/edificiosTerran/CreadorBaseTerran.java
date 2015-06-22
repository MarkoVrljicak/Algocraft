package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorBaseTerran extends EdificiosAbstractFactory {
		
	public CreadorBaseTerran(){
		this.recursosNecesarios = new Recurso(0,0);
		this.vida = 2500;
		this.tiempoDeConstruccion = 0;
	}
	
	@Override
	public Construccion crearEdificio() {
		return new EdificioBasico(EnumEdificiosTerran.BASE_TERRAN,vida,tiempoDeConstruccion);
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
