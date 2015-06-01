package algocraft.construcciones;

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
	
}
