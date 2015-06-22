package modelo.construcciones;

import modelo.ataques.Ataques;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;

public abstract class DecoradorEdificioBasico extends Propiedad implements Construccion {

	public Construccion edificio;

	public DecoradorEdificioBasico(Construccion construccionDecorada){
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
	
	public Jugador getDuenio(){
		return this.edificio.getDuenio();
	}
	
	public Colores getColor(){
		return this.edificio.getColor();
	}
	
	public void setDuenio(Jugador jugador){
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
	
	public int getPoblacionSumada(){
		return this.edificio.getPoblacionSumada();
	}

	@Override
	public void quitarEnergia() {
		//no responde.
	}	
	
	
}

