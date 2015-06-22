package modelo.factory.unidadesProtoss;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.protos.AltoTemplario;

public class CreadorAltoTemplario extends UnidadesAbstractFactory {

	public CreadorAltoTemplario(){
		this.recursosNecesarios = new Recurso(50,150);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new AltoTemplario();
	}

}
