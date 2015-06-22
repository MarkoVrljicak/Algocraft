package modelo.movimientos;

import modelo.mapa.terrenos.Terreno;

public class MovimientoAereo extends Movimiento {
	
	public boolean validarPaso(Terreno terrenoSiguiente){
		return terrenoSiguiente.sePuedeVolar();
	}
}
