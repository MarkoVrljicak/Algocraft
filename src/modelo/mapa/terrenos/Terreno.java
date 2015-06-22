package modelo.mapa.terrenos;

import modelo.Interfaces.Dibujable;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.Coordenada;
import modelo.propiedad.Propiedad;

public abstract class Terreno implements Dibujable {
	
	protected Terrenos nombre;
	protected Propiedad contenidoSuelo;
	protected Propiedad contenidoCielo;
	protected Coordenada coordenada;
	
	/*-------------------------------------*/
	/*            Sets y gets              */
	/*-------------------------------------*/
	
	public Terrenos getNombre(){
		return nombre;
	}
		
	abstract public void almacenarEnSuelo(Propiedad propiedad) throws DestinoInvalidoException;
	
	public void almacenarEnCielo(Propiedad propiedad) throws DestinoInvalidoException{
		
		if (contenidoCielo != null) {
			throw new DestinoInvalidoException();
			
		} else {
			contenidoCielo = propiedad;
		}
	}
		
	abstract public Propiedad getContenidoSuelo();
	abstract public Propiedad getContenidoCielo();
		
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	public void vaciarSuelo() {
		this.contenidoSuelo = null;
	}

	public void vaciarCielo() {
		this.contenidoCielo = null;
		
	}
	
	public void almacenar(Propiedad propiedad) throws DestinoInvalidoException{
		propiedad.almacenarme(this);
	}
	
	public void borrarContenido(Propiedad propiedad) throws PropiedadNoExisteEnEstaUbicacion {
		if(this.getContenidoSuelo() == propiedad){
			this.contenidoSuelo = null;
			
		} else if(this.getContenidoCielo() == propiedad){
			this.contenidoCielo = null;
			
		} else {
			throw new PropiedadNoExisteEnEstaUbicacion();
		}
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







		
		
		
}
