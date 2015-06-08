package algocraft.construccionesAlternativas;

import stats.Escudo;

public class EdificioConEscudo extends EdificioBasico{

	private Escudo escudo = new Escudo();

	public EdificioConEscudo(EnumEdificios nombre, int vidaMaxima, int tiempoDeConstruccion, int escudoMaximo) {
		super(nombre, vidaMaxima, tiempoDeConstruccion);
		this.escudo.set(escudoMaximo);
	}
	
	public int getEscudo() {
		return escudo.actual();
	}
	
	public void pasarTurno() {
		this.disminuirTiempoDeConstruccion();
		//falta disminuir escudo
	}
}
