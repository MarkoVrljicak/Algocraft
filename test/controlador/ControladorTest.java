package controlador;

import static org.junit.Assert.*;
import modelo.Juego;
import modelo.exception.ColorRepetidoExcepcion;
import modelo.exception.MinimoCuatroCaracteresException;
import modelo.exception.NombreRepetidoExcepcion;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.jugador.Colores;
import modelo.razas.EnumRazas;

import org.junit.Test;

import visual.Algocraft;

public class ControladorTest {
	
	private void iniciarJugadoresBien(Controlador controlador) {
		try {
			controlador.ingresarDatosJugador1("Nico", EnumRazas.TERRAN, Colores.AZUL);
			controlador.ingresarDatosJugador2("Nico2", EnumRazas.TERRAN, Colores.ROJO);
		} catch (MinimoCuatroCaracteresException | NombreRepetidoExcepcion
				| ColorRepetidoExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInicioJuegoVerificoQueNoHallaGanador() throws PropiedadNoEstaEnJuegoException, RecursosNegativosException{
		Algocraft aplicacion = new Algocraft();
		Juego juego = aplicacion.getJuego();		
		Controlador controlador = new Controlador(aplicacion,juego);
		
		iniciarJugadoresBien(controlador);
		
		
		controlador.iniciarJuego();
		
		assertFalse(juego.hayGanador());
	}
	
	@Test
	public void testPasoTurnoVerificoQueNoHallaGanador() throws PropiedadNoEstaEnJuegoException, RecursosNegativosException{
		Algocraft aplicacion = new Algocraft();
		Juego juego = aplicacion.getJuego();
		Controlador controlador = new Controlador(aplicacion,juego);
		iniciarJugadoresBien(controlador);
		controlador.iniciarJuego();
		
		controlador.pasarTurno();
		
		assertFalse(juego.hayGanador());
	}

	
}
