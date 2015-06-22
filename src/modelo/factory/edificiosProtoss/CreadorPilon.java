package modelo.factory.edificiosProtoss;

import modelo.construcciones.Construccion;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EdificioConEscudo;
import modelo.construcciones.EnumEdificios;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

public class CreadorPilon extends EdificiosAbstractFactory {

	private int escudo;

	public CreadorPilon(){
		this.recursosNecesarios = new Recurso(100,0);
		this.vida = 300;
		this.tiempoDeConstruccion = 5;
		this.escudo = 300;
	}
	
	@Override
	public Construccion crearEdificio() {
		EdificioBasico pilon = new EdificioConEscudo(EnumEdificiosProtos.PILON,vida,tiempoDeConstruccion,escudo);
		pilon.setPoblacionSumada(5);
		return pilon;
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
