package modelo.construcciones;

import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.jugador.Jugador;

public class RecolectorGas extends DecoradorEdificioBasico {

	public RecolectorGas(Construccion construccionDecorada) {
		super(construccionDecorada);
	}

	@Override
	public void iniciarTurno() throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion {
		this.edificio.iniciarTurno();
		recolectarGas(this.edificio.getDuenio());
	}

	public void recolectarGas(Jugador jugador) {
		jugador.incrementarGas(10);		
	}

	@Override
	public boolean soyVolador() {
		return false;
	}
	
}
