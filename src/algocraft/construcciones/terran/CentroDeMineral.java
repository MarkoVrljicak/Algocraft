package algocraft.construcciones.terran;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;

public class CentroDeMineral extends Construccion{
	
	public CentroDeMineral() {
		this.nombre = "Centro De Mineral";
		this.tiempoDeConstruccion = 4;
		this.vida.set(500);
	}
	
	public Creable clonar(){
		return (new CentroDeMineral());
	}

	@Override
	public void actualizar() {
		this.recolectarMineral(duenio.getRecursos());		
	}

	public void recolectarMineral(Recurso recursos) {
		recursos.incrementarRecurso(new Recurso(10,0));
	}

}
