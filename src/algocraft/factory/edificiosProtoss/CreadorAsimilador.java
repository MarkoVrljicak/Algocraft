package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.RecolectorGas;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorAsimilador extends EdificiosAbstractFactory {

	public CreadorAsimilador(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public RecolectorGas crearEdificio() {
		return new RecolectorGas(new EdificioConEscudo(EnumEdificiosProtos.ASIMILADOR,450,6,450));
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
