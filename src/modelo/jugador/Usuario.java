package modelo.jugador;

import modelo.construcciones.EnumEdificios;

public interface Usuario {

	public int getMineral();
	public int getGas();
	public int getPoblacionActual();
	public boolean tieneConstruccion(EnumEdificios nombreEdificio);
	public int getPoblacionDisponible();
}
