package algocraft.ataques;

import algocraft.mapa.terrenos.Terreno;

abstract public class Ataque {
	abstract public boolean ejecutarAtaque(Terreno terrenoDestino, int distancia);
}
