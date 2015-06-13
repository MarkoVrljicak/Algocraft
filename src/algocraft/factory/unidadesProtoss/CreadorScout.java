package algocraft.factory.unidadesProtoss;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.Scout;

public class CreadorScout extends UnidadesAbstractFactory {

	public CreadorScout(){
		this.recursosNecesarios = new Recurso(300,150);
		this.poblacionNecesaria = 3;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Scout();
	}

}
