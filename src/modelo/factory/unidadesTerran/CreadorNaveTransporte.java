package modelo.factory.unidadesTerran;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.terran.NaveTransporte;

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
