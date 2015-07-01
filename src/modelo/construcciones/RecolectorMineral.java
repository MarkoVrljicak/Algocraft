package modelo.construcciones;

import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.jugador.Jugador;

public class RecolectorMineral extends DecoradorEdificioBasico{

	public RecolectorMineral(Construccion construccionDecorada) {
		super(construccionDecorada);
	}

	@Override
	public void iniciarTurno() throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion {
		this.edificio.iniciarTurno();
		recolectarMineral(this.getDuenio());
	}

	public void recolectarMineral(Jugador jugador) {
		jugador.incrementarMineral(10);		
	}

	@Override
	public boolean soyVolador() {
		return false;
	}
}
