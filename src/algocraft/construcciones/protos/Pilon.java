package algocraft.construcciones.protos;

import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;

public class Pilon extends Construccion {

	public Pilon() {
		this.nombre = "Pilon";
		this.tiempoDeConstruccion = 5;
		this.vida.set(300);
	}
	
	@Override
	public Creable clonar() {
		return new Pilon();
	}
	
	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
	}
	
	@Override
	protected void disminuirTiempoDeConstruccion() {
		disminuirTiempoDeConstruccion();
		if(tiempoDeConstruccion == 0){
			this.duenio.getPoblacion().incrementarMaxima(5);
		}
	}

}
