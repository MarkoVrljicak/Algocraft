package modelo.movimientos;

import modelo.mapa.terrenos.Terreno;

public class MovimientoTerrestre extends Movimiento{
	
	public boolean validarPaso(Terreno terrenoSiguiente){
		return terrenoSiguiente.sePuedeCaminar();
	}
	
}
