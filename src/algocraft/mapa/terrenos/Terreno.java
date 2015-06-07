package algocraft.mapa.terrenos;

import algocraft.creables.Creable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Dibujable;

public abstract class Terreno implements Dibujable {
	
	protected Terrenos nombre;
	protected Creable contenidoSuelo;
	protected Creable contenidoCielo;
	protected Coordenada coordenada;
	
	/*-------------------------------------*/
	/*            Sets y gets              */
	/*-------------------------------------*/
	
	public Terrenos getNombre(){
		return nombre;
	}
		
	abstract public void almacenarEnSuelo(Creable creable) throws DestinoInvalidoException;
	
	public void almacenarEnCielo(Creable creable) throws DestinoInvalidoException{
		
		if (contenidoCielo != null) {
			throw new DestinoInvalidoException();
			
		} else {
			contenidoCielo = creable;
		}
	}
		
	abstract public Creable getContenidoSuelo();
	abstract public Creable getContenidoCielo();
		
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	/*-------------------------------------*/
	/* Metodos para permisos de movimiento */
	/*-------------------------------------*/
	abstract public boolean sePuedeCaminar();
	//Para que las unidades a pie pregunten si pueden transitar por el casillero.
	
	public boolean sePuedeVolar() {
		return (contenidoCielo == null);
	}
	//Para que las unidades voladoras pregunten si pueden navegar por el casillero.
	
	/*-------------------------------------*/
	/* Metodos de permisos de construccion */
	/*-------------------------------------*/
	
	abstract public boolean sePuedeMinar();
	//Para que los centros y nexos de minerales pregunten si pueden ser construidos.
	
	abstract public boolean tieneGas();
	//Para que las refinerias y asimiladores sepan si pueden ser construidos.
	
	abstract public boolean sePuedeEdificar();
	//Para que los edificios que no sean recolectores de recursos sepan si pueden ser construidos.

	public void vaciarSuelo() {
		this.contenidoSuelo = null;
	}

		
		
		
}
