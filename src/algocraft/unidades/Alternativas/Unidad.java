package algocraft.unidades.Alternativas;

import stats.Vida;
import algocraft.ataques.Ataque;
import algocraft.construccionesAlternativas.Actualizable;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;

public abstract class Unidad implements Daniable, Movible, Actualizable{
	
	protected Unidades nombre;
	protected Vida vida = new Vida();
	protected int pesoTransporte;
	protected Ataque ataque;

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
	
	//los que tengan escudo deberian pisarlo
	public void recibirDanio(int cantidadDanio){
		vida.disminuir(cantidadDanio);
	}
	
	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		if (this.soyVolador()){
			return terrenoDestino.sePuedeVolar();
		} else {
			return terrenoDestino.sePuedeCaminar();
		}
	}
	
	@Override
	public void pasarTurno() {
		// TODO Auto-generated method stub
		
	}


	abstract public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector, int distancia);

}
