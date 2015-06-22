package modelo.factory.unidadesProtoss;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.protos.Zealot;

public class CreadorZealot extends UnidadesAbstractFactory {

	public CreadorZealot(){
		this.recursosNecesarios = new Recurso(100,0);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Zealot();
	}

}
