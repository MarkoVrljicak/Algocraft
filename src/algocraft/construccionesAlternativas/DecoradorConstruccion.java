package algocraft.construccionesAlternativas;

import jugador.Usuario;

public abstract class DecoradorConstruccion implements Construccion {

	public Construccion edificio;

	public DecoradorConstruccion(Construccion construccionDecorada){
		this.edificio=construccionDecorada;
	}
	
	public int getVida(){
		return this.edificio.getVida();
	}
	public Edificios getNombre(){
		return this.edificio.getNombre();
		
	}
	public boolean enConstruccion() {
		return this.edificio.enConstruccion();
	}
	
	public Usuario getDuenio(){
		return this.edificio.getDuenio();
	}
}
