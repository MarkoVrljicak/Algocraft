package algocraft.ataques;

import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;

abstract public class Ataque {
	abstract public boolean ejecutarAtaque(Terreno terrenoDestino, SectoresDeTerreno sector, int distancia);
}
