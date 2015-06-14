package algocraft.movimientos;

import algocraft.mapa.terrenos.Terreno;

public class MovimientoTerrestre extends Movimiento{
	
	public boolean validarPaso(Terreno terrenoSiguiente){
		return terrenoSiguiente.sePuedeCaminar();
	}
	
}
