package algocraft.construcciones.protos;

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
	}

}
