package algocraft.factory.unidadesProtoss;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.Dragon;

public class CreadorDragon extends UnidadesAbstractFactory {

	public CreadorDragon(){
		this.recursosNecesarios = new Recurso(125,50);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Dragon();
	}

}
