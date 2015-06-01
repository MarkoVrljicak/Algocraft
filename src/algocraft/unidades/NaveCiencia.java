package algocraft.unidades;

import algocraft.Creable;

public class NaveCiencia extends Unidad{

	public NaveCiencia() {
		nombre = "Nave Ciencia";
		this.vida.set(200);
	}
	
	public Creable clonar(){
		return new NaveCiencia();
	}
}
