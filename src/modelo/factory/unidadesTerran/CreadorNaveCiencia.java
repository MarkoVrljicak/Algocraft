package modelo.factory.unidadesTerran;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.terran.NaveCiencia;

public class CreadorNaveCiencia extends UnidadesAbstractFactory {

	public CreadorNaveCiencia(){
		this.recursosNecesarios = new Recurso(100,225);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new NaveCiencia();
	}

}
