package algocraft.construccionesAlternativas;

import jugador.JugadorNulo;
import jugador.Usuario;
import stats.Stat;
import stats.Vida;
import algocraft.ataques.Ataques;

public class EdificioBasico implements Construccion{

	protected Stat stat;
	protected int tiempoDeConstruccion;
	protected EnumEdificios nombre;
	public Usuario duenio = new JugadorNulo();
	
	public EdificioBasico(EnumEdificios nombre, int vidaMaxima, int tiempoDeConstruccion){
		this.nombre= nombre;
		this.stat = new Vida(vidaMaxima);
		this.tiempoDeConstruccion=tiempoDeConstruccion;
	}
	

	public int getVida() {
		return stat.actual();
	}
	
		
	public EnumEdificios getNombre(){
		return nombre;
	}
	
	
	protected void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	public void setDuenio(Usuario jugador) {
		duenio = jugador;		
	}
	
	public Usuario getDuenio() {
		return duenio;		
	}

	@Override
	public void pasarTurno() {
		this.disminuirTiempoDeConstruccion();		
	}


	public boolean enConstruccion() {
		if(tiempoDeConstruccion==0)
			return false;
		else
			return true;
	}

	@Override
	public void recibirDanio(int cantidadDanio) {
		stat.disminuir(cantidadDanio);
	}

	@Override
	public Ataques comoAtacarme() {
		return Ataques.ATAQUE_NORMAL_TERRESTRE;
	}

	@Override
	public boolean estoyMuerto() {
		return stat.estoyVacio();
	}
	
}
