package modelo.factory.unidadesProtoss;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.protos.NaveDeTransporte;

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
