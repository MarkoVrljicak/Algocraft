package algocraft.construcciones.terran;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;

public class Refineria extends Construccion {

	public Refineria() {
		this.nombre = "Refineria";
		this.vida.set(750);
		this.tiempoDeConstruccion = 6;
	}

	@Override
	public Creable clonar() {
		return new Refineria();
	}

	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
		if(tiempoDeConstruccion == 0){
			recolectarGas(this.duenio.getRecursos());
		}
	}
	
	public void recolectarGas(Recurso recursos) {
		recursos.incrementarRecurso(new Recurso(0,10));
		
	}

}
