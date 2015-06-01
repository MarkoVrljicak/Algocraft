package algocraft.unidades;

import algocraft.creables.Creable;

public class Zealot extends Unidad{

	public Zealot() {
		nombre = "Zealot";
		this.vida.set(100);
	}

	@Override
	public Creable clonar() {
		
		return new Zealot();
	}

}
