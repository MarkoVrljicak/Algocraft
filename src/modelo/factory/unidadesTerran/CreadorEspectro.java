package modelo.factory.unidadesTerran;

import modelo.factory.UnidadesAbstractFactory;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Espectro;

public class CreadorEspectro extends UnidadesAbstractFactory {

	public CreadorEspectro(){
		this.recursosNecesarios = new Recurso(150,100);
		this.poblacionNecesaria = 2;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Espectro();
	}
}
