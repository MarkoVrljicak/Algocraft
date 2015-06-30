package modelo.construcciones;

import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;
import modelo.stats.Stat;
import modelo.stats.Vida;

public class EdificioBasico extends Propiedad implements Construccion{

	protected Stat vitalidad;
	protected int tiempoDeConstruccion;
	protected EnumEdificios nombre;
	public Jugador duenio;
	protected int poblacionSumada;
	private Colores color = Colores.GRIS;
	
	public EdificioBasico(EnumEdificios nombre, int vidaMaxima, int tiempoDeConstruccion){
		this.nombre= nombre;
		this.vitalidad = new Vida(vidaMaxima);
		this.tiempoDeConstruccion=tiempoDeConstruccion;
		this.setPoblacionSumada(0);
	}
	

	public int getVida(){
		return this.vitalidad.actual();
	}
	
	public int getVidaMaxima(){
		return this.vitalidad.max();
	}
	
	public int getEscudo(){
		return 0;
	}
	
	public int getEscudoMaximo(){
		return 0;
	}
	
		
	public EnumEdificios getNombre(){
		return nombre;
	}
	
	
	protected void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	public void setDuenio(Jugador jugador) {
		duenio = jugador;
		color = jugador.getColor();
	}
	
	public Jugador getDuenio() {
		return duenio;		
	}
	
	
	public Colores getColor(){
		return this.color;
	}

	@Override
	public void iniciarTurno() {
		this.disminuirTiempoDeConstruccion();		
	}


	public boolean enConstruccion() {
		return (tiempoDeConstruccion!=0);
	}

	@Override
	public void recibirDanio(int cantidadDanio) {
		vitalidad.disminuir(cantidadDanio);
	}

	@Override
	public boolean estoyMuerto() {
		return vitalidad.estoyVacio();
	}


	@Override
	public boolean soyVolador() {
		return false;
	}
	
	public void setPoblacionSumada(int cantidad){
		this.poblacionSumada = cantidad;
	}
	
	public int getPoblacionSumada(){
		if (!this.estoyMuerto())
			return this.poblacionSumada;
		else
			return 0;
	}


	@Override
	public void quitarEnergia() {
		//no responde
	}


	@Override
	public int getTiempoConstruccion() {
		return tiempoDeConstruccion;
	}
}
