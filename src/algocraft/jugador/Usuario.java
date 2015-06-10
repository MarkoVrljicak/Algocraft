package algocraft.jugador;

import algocraft.construcciones.EnumEdificios;
import algocraft.stats.Recurso;

public interface Usuario {

	public Recurso getRecursos();
	public int getPoblacionActual();
	public boolean tieneConstruccion(EnumEdificios nombreEdificio);
	public int getPoblacionDisponible();
}
