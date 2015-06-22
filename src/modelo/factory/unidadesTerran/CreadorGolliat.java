package modelo.factory.unidadesTerran;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Golliat;

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
