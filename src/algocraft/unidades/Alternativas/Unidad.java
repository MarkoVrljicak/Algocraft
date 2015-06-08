package algocraft.unidades.Alternativas;

import stats.Vida;

public abstract class Unidad {
	
	protected Unidades nombre;
	protected Vida vida = new Vida();
	protected int pesoTransporte;

	//Template method
	protected void inicializar() {
		this.setearVida();
		this.setearNombre();
		this.setearPesoTransporte();
	}

	
	abstract protected void setearPesoTransporte();
	abstract protected void setearNombre();
	abstract protected void setearVida();
	
	public Unidades getNombre(){
		return nombre;
	}
	
	public int getVida(){
		return vida.actual();
	}
	
	public boolean soyVolador(){
		return (pesoTransporte == 0);
	}

}
