package algocraft.movimientos;

import java.util.Collection;
import java.util.Iterator;

import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.PropiedadNoExisteEnEstaUbicacion;
import algocraft.mapa.Coordenada;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

abstract public class Movimiento {
	
	abstract public boolean validarPaso(Terreno terrenoSiguiente);
	
	public Coordenada ejecutar(Collection<Terreno> camino, Unidad unidad){
		Iterator<Terreno> iter = camino.iterator();
		
		Terreno terrenoOriginal = null;
		Terreno proximoTerreno = iter.next();
		
		while(iter.hasNext()){
			terrenoOriginal = proximoTerreno;
			proximoTerreno = iter.next();
			
			if(!this.validarPaso(proximoTerreno) || unidad.getMovimientos() < 1){
				return terrenoOriginal.getCoordenada();
				
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
				terrenoOriginal = proximoTerreno;
			}
		}
		
		return terrenoOriginal.getCoordenada();
	}
}
