package controlador;

import modelo.Juego;
import modelo.mapa.Coordenada;

public interface StrategyAccion {

	public void accionSuelo(Coordenada posicion,Juego juego,Controlador controlador);
}
