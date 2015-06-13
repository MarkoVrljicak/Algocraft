package algocraft.factory.unidadesTerran;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.NaveCiencia;

public class CreadorNaveCiencia extends UnidadesAbstractFactory {

	public CreadorNaveCiencia(){
		this.recursosNecesarios = new Recurso(100,225);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new NaveCiencia();
	}

}
