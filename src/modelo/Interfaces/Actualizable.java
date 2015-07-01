package modelo.Interfaces;

import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;

public interface Actualizable {

	public  void iniciarTurno() throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion;

}
