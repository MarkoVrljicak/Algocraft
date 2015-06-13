package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorBaseProtoss extends EdificiosAbstractFactory {

	public CreadorBaseProtoss(){
		this.recursosNecesarios = new Recurso(0,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new EdificioConEscudo(EnumEdificiosProtos.BASE_PROTOSS,1300,0,1200);
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
