package algocraft.factory.unidadesProtoss;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.Zealot;

public class CreadorZealot extends UnidadesAbstractFactory {

	public CreadorZealot(){
		this.recursosNecesarios = new Recurso(100,0);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Zealot();
	}

}
