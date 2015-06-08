package algocraft.unidades;

import stats.Vida;
import algocraft.ataques.Ataque;
import algocraft.creables.Creable;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;

public abstract class Unidad implements Creable, Movible, Daniable{

	protected String nombre;
	protected int tiempoDeCreacion;
	protected Vida vida = new Vida();
	protected Ataque ataque;
	
	public int getVida() {
		return vida.actual();
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int tiempoDeCreacion() {
		return tiempoDeCreacion;
	}

	@Override
	abstract public Creable clonar();
	
	public void recibirDanio(int cantidadDanio){
		vida.disminuir(cantidadDanio);
	}
	
	public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector, int distancia){
		return ataque.ejecutarAtaque(terrenoDestino, sector, distancia);
	}
}
