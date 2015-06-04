package algocraft.unidades.Alternativas;

import stats.Vida;

public class Unidad {
	
	private Unidades nombre;
	private Vida vida = new Vida();

	public Unidad(Unidades nombre, int vida) {
		this.nombre=nombre;
		this.vida.set(vida);
	}
	
	public Unidades getNombre(){
		return nombre;
	}
	
	public int getVida(){
		return vida.actual();
	}

}
