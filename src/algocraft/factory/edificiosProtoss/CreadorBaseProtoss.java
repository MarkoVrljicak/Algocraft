package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorBaseProtoss extends EdificiosAbstractFactory {

	private int escudo;

	public CreadorBaseProtoss(){
		this.recursosNecesarios = new Recurso(0,0);
		this.vida = 1300;
		this.tiempoDeConstruccion = 0;
		this.escudo = 1200;
	}
	
	@Override
	public Construccion crearEdificio() {
		return new EdificioConEscudo(EnumEdificiosProtos.BASE_PROTOSS,vida,tiempoDeConstruccion,escudo);
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
