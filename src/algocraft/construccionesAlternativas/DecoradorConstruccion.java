package algocraft.construccionesAlternativas;

import algocraft.ataques.Ataques;
import jugador.Usuario;

public abstract class DecoradorConstruccion implements Construccion {

	public Construccion edificio;

	public DecoradorConstruccion(Construccion construccionDecorada){
		this.edificio=construccionDecorada;
	}
	
	public int getVida(){
		return this.edificio.getVida();
	}
	public EnumEdificios getNombre(){
		return this.edificio.getNombre();
		
	}
	public boolean enConstruccion() {
		return this.edificio.enConstruccion();
	}
	
	public Usuario getDuenio(){
		return this.edificio.getDuenio();
	}
	
	public void setDuenio(Usuario jugador){
		this.edificio.setDuenio(jugador);
	}
	
	@Override
	public void recibirDanio(int cantidadDanio) {
		this.edificio.recibirDanio(cantidadDanio);
		
	}

	@Override
	public Ataques comoAtacarme() {
		return Ataques.ATAQUE_NORMAL_TERRESTRE;
	}

	@Override
	public boolean estoyMuerto() {
		return this.edificio.estoyMuerto();
	}
}

