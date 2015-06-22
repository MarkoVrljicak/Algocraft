package modelo.factory.edificiosTerran;

import modelo.construcciones.Construccion;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EnumEdificios;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

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
