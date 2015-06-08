package algocraft.unidades.Alternativas;

import stats.Vida;

public abstract class Unidad {
	
	protected Unidades nombre;
	protected Vida vida = new Vida();
	protected boolean volador;

	//Template method
	protected void inicializar() {
		this.setearVida();
		this.setearNombre();
		this.volador = this.soyVolador();
	}

	abstract protected boolean soyVolador();
	abstract protected void setearNombre();
	abstract protected void setearVida();
	
	public Unidades getNombre(){
		return nombre;
	}
	
	public int getVida(){
		return vida.actual();
	}

}
