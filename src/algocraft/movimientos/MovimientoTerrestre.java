package algocraft.movimientos;

import java.util.Collection;
import java.util.Iterator;

import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.PropiedadNoExisteEnEstaUbicacion;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class MovimientoTerrestre extends Movimiento{
	
	
	public void ejecutar(Collection<Terreno> camino, Unidad unidad){
		
		Iterator<Terreno> iter = camino.iterator();
		
		Terreno terrenoOriginal = null;
		Terreno proximoTerreno = iter.next();
		
		while(iter.hasNext()){
			terrenoOriginal = proximoTerreno;
			proximoTerreno = iter.next();
			
			if(!proximoTerreno.sePuedeCaminar() || unidad.getMovimientos() < 1){
				break;
				
			} else {
				try {
					proximoTerreno.almacenar(unidad);
				} catch (DestinoInvalidoException e) {
					// No deberia, se chequeo anteriormente.
					e.printStackTrace();
				} 
				
				try {
					terrenoOriginal.borrarContenido(unidad);
				} catch (PropiedadNoExisteEnEstaUbicacion e) {
					e.printStackTrace();
				}
				
				unidad.darPaso();
			}
		}
		
	}
	
	
}
