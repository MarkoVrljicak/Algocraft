package modelo.factory.edificiosProtoss;

import modelo.construcciones.Construccion;
import modelo.construcciones.EdificioConEscudo;
import modelo.construcciones.EnumEdificios;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

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
