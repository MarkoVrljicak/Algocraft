package algocraft.factory.unidadesTerran;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.NaveTransporte;

public class CreadorNaveTransporte extends UnidadesAbstractFactory {
	
	public CreadorNaveTransporte(){
		this.recursosNecesarios = new Recurso(100,100);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new NaveTransporte();
	}

}
