package algocraft.construcciones;

import algocraft.stats.Escudo;

public class EdificioConEscudo extends EdificioBasico{

	public EdificioConEscudo(EnumEdificios nombre, int vidaMaxima, int tiempoDeConstruccion, int escudoMaximo) {
		super(nombre, vidaMaxima, tiempoDeConstruccion);
		this.stat = new Escudo(escudoMaximo, this.stat);
	}
	
	public int getEscudo() {
		return stat.actual();
	}
	
	public int getVida(){
		return ((Escudo)stat).actualProtegida();
	}
	
	public void iniciarTurno() {
		super.iniciarTurno();
		this.stat.regenerar();
	}
}
