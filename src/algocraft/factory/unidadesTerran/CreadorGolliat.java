package algocraft.factory.unidadesTerran;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Golliat;

public class CreadorGolliat extends UnidadesAbstractFactory {

	public CreadorGolliat(){
		this.recursosNecesarios = new Recurso(100,50);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Golliat();
	}

}
