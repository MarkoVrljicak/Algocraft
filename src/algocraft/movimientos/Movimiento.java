package algocraft.movimientos;

import java.util.Collection;

import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

abstract public class Movimiento {
	abstract public void ejecutar(Collection<Terreno> camino, Unidad unidad);
}
