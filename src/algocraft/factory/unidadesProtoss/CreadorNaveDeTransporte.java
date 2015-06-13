package algocraft.factory.unidadesProtoss;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.NaveDeTransporte;

public class CreadorNaveDeTransporte extends UnidadesAbstractFactory {

	public CreadorNaveDeTransporte(){
		this.recursosNecesarios = new Recurso(200,0);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new NaveDeTransporte();
	}

}
