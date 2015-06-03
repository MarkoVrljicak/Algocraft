package algocraft.construcciones.terran;

import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;

public class DepositoDeSuministros extends Construccion {
	
	public DepositoDeSuministros() {
		this.nombre = "Deposito De Suministros";
		this.tiempoDeConstruccion = 6;
		this.vida.set(500);
	}

	@Override
	public Creable clonar() {
		return (new DepositoDeSuministros());
	}

	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
	}
	
	@Override
	public void disminuirTiempoDeConstruccion(){
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
			if(tiempoDeConstruccion==0) 
				this.duenio.getPoblacion().incrementarMaxima(5);
		}
	}
	
}
