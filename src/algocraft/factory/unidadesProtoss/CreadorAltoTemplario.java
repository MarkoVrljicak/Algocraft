package algocraft.factory.unidadesProtoss;

import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.AltoTemplario;

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
