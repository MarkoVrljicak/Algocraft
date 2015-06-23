package modelo.Interfaces;

import modelo.exception.PropiedadNoEstaEnJuegoException;

public interface Actualizable {

	public  void iniciarTurno() throws PropiedadNoEstaEnJuegoException;

}
