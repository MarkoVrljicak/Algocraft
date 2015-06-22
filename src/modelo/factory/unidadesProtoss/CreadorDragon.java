package modelo.factory.unidadesProtoss;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.protos.Dragon;

public class CreadorDragon extends UnidadesAbstractFactory {

	public CreadorDragon(){
		this.recursosNecesarios = new Recurso(125,50);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Dragon();
	}

}
