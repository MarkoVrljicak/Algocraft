package algocraft.factory.unidadesTerran;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;

public class CreadorMarine extends UnidadesAbstractFactory {

	public CreadorMarine(){
		this.recursosNecesarios = new Recurso(50,0);
		this.poblacionNecesaria = 1;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Marine();
	}

}
