package algocraft.movimientos;

import algocraft.mapa.terrenos.Terreno;

public class MovimientoAereo extends Movimiento {
	
	public boolean validarPaso(Terreno terrenoSiguiente){
		return terrenoSiguiente.sePuedeVolar();
	}
}
