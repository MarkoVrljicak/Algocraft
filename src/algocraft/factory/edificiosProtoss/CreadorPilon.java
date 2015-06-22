package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

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
