package modelo.factory.unidadesProtoss;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.protos.Scout;

public class CreadorScout extends UnidadesAbstractFactory {

	public CreadorScout(){
		this.recursosNecesarios = new Recurso(300,150);
		this.poblacionNecesaria = 3;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Scout();
	}

}
