package modelo.construcciones;

import modelo.stats.Escudo;

public class EdificioConEscudo extends EdificioBasico{

	public EdificioConEscudo(EnumEdificios nombre, int vidaMaxima, int tiempoDeConstruccion, int escudoMaximo) {
		super(nombre, vidaMaxima, tiempoDeConstruccion);
		this.vitalidad = new Escudo(escudoMaximo, this.vitalidad);
	}
	
	public int getVida(){
		return ((Escudo)this.vitalidad).actualProtegida();
	}
	
	public int getVidaMaxima(){
		return ((Escudo)this.vitalidad).maxProtegida();
	}
	
	public int getEscudo(){
		return this.vitalidad.actual();
	}
	
	public int getEscudoMaximo(){
		return this.vitalidad.max();
	}
	
	public void iniciarTurno() {
		super.iniciarTurno();
		this.vitalidad.regenerar();
	}
}
