package algocraft.construcciones.protos;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;

public class Asimilador extends Construccion {

	public Asimilador() {
		this.nombre = "Asimilador";
		this.vida.set(450);
		this.tiempoDeConstruccion = 6;
	}
	
	@Override
	public Creable clonar() {
		return new Asimilador();
	}

	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
		recolectarGas(this.duenio.getRecursos());
	}
	
	public void recolectarGas(Recurso recursos) {
		recursos.incrementarRecurso(new Recurso(0,10));
		
	}

}
