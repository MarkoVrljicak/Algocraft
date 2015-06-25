package modelo.movimientos;

import java.util.Collection;
import java.util.Iterator;

import modelo.exception.DestinoInvalidoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import modelo.unidades.Unidad;

abstract public class Movimiento {
	
	abstract public boolean validarPaso(Terreno terrenoSiguiente);
	
	public Coordenada ejecutar(Collection<Terreno> camino, Unidad unidad) throws PropiedadNoExisteEnEstaUbicacion, DestinoInvalidoException{
		
		
		Iterator<Terreno> iter = camino.iterator();
		
		Terreno terrenoOriginal = null;
		Terreno proximoTerreno = iter.next();
		
		while(iter.hasNext()){
			terrenoOriginal = proximoTerreno;
			proximoTerreno = iter.next();
			
			if(!unidad.puedoMoverme(proximoTerreno) || unidad.getMovimientos() < 1){
				return terrenoOriginal.getCoordenada();
				
			} else {
				proximoTerreno.almacenar(unidad);
				
				terrenoOriginal.borrarContenido(unidad);
				
				unidad.darPaso();
				terrenoOriginal = proximoTerreno;
			}
		}
		
		return terrenoOriginal.getCoordenada();
	}
}
