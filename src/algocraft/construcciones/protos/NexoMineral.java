package algocraft.construcciones.protos;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;

public class NexoMineral extends Construccion {

	public NexoMineral() {
		this.nombre = "Nexo Mineral";
		this.tiempoDeConstruccion = 4;
		this.vida.set(250);
	}
	@Override
	public Creable clonar() {
		return new NexoMineral();
	}
	
	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
		if(tiempoDeConstruccion == 0){
			this.recolectarMineral(duenio.getRecursos());
		}
	}

	public void recolectarMineral(Recurso recursos) {
		recursos.incrementarRecurso(new Recurso(10,0));
	}

}
