package algocraft.factory.unidadesTerran;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Espectro;

public class CreadorEspectro extends UnidadesAbstractFactory {

	public CreadorEspectro(){
		this.recursosNecesarios = new Recurso(150,100);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Espectro();
	}
}
