package Interfaces;

import algocraft.construccionesAlternativas.EnumEdificios;
import stats.Recurso;

public interface Usuario {

	public Recurso getRecursos();
	public int getPoblacionActual();
	public boolean tieneConstruccion(EnumEdificios nombreEdificio);
	public int getPoblacionDisponible();
}
