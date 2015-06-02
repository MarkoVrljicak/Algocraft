package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.unidades.Unidad;

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
