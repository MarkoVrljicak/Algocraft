package modelo.factory.unidadesTerran;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Marine;

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
