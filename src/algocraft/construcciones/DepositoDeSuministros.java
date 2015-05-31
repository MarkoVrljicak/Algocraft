package algocraft.construcciones;

import algocraft.Creable;

public class DepositoDeSuministros extends Construccion {
	
	public DepositoDeSuministros() {
		this.nombre = "Deposito De Suministros";
		this.vidaMaxima.setVida(500);
	}
	
	public Creable crear(){
		return (new DepositoDeSuministros());
	}
	
}
