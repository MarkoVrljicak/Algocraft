package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorPilon extends EdificiosAbstractFactory {

	public CreadorPilon(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		EdificioBasico pilon = new EdificioConEscudo(EnumEdificiosProtos.PILON,300,5,300);
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
