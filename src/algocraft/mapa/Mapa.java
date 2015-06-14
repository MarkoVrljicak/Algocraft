package algocraft.mapa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import Propiedad.Propiedad;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.exception.PropiedadNoEstaEnJuegoException;
import algocraft.exception.PropiedadNoExisteEnEstaUbicacion;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Unidad;

public class Mapa implements Iterable<Terreno>{

	private HashMap<Coordenada, Terreno> casilleros;
	private HashMap<Propiedad, Coordenada> posiciones;
	private int ancho;
	private int alto;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		casilleros = new HashMap<Coordenada, Terreno>();
		posiciones = new HashMap<Propiedad, Coordenada>();

		for (int i = 1; i <= this.ancho; i++) {
			for (int j = 1; j <= this.alto; j++) {
				setearTerrenoEnCoordenada(Terrenos.TIERRA, i, j);
			}
		}
	}
	
	//accesors
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public void setearTerrenoEnCoordenada(Terrenos terreno, int i, int j){
		Coordenada nuevaCoordenada = new Coordenada(i, j);
		Terreno nuevoTerreno = terreno.crear(i, j);
		casilleros.put(nuevaCoordenada, nuevoTerreno);
	}
	
	public boolean hayCasillero(Coordenada coordenada) {
		boolean dentroDelAncho=(coordenada.getX()>0 && coordenada.getX()<=this.ancho);
		boolean dentroDelAlto=(coordenada.getY()>0 && coordenada.getY()<=this.alto);
		return (dentroDelAncho && dentroDelAlto);
	}

	public Terreno getTerreno(Coordenada coordenadaPedida)throws FueraDeLimitesException {
		if (this.hayCasillero(coordenadaPedida))
			return casilleros.get(coordenadaPedida);
		else
			throw new FueraDeLimitesException();
	}
	

	@Override
	public Iterator<Terreno> iterator() {
		
		return casilleros.values().iterator();
	}
	
	public void almacenar(Propiedad propiedad, Coordenada coordenada)
			throws DestinoInvalidoException, FueraDeLimitesException {
		posiciones.put(propiedad, coordenada);
		this.getTerreno(coordenada).almacenar(propiedad);
	}
	
	public Propiedad getPropiedadSuelo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return this.getTerreno(coordenada).getContenidoSuelo();
	}

	public Propiedad getPropiedadCielo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return this.getTerreno(coordenada).getContenidoCielo();
	}
	
	//movimiento

//	public boolean moverUnidad(Unidad unidad, Coordenada coordenadaDestino) 
//			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException {
//		
//		Coordenada coordenadaOrigen = posiciones.get( unidad );
//		if(coordenadaOrigen == null){
//			throw new PropiedadNoEstaEnJuegoException();
//		}
//		
//		Terreno terrenoOrigen = this.getTerreno(coordenadaOrigen);
//		Terreno terrenoDestino = this.getTerreno(coordenadaDestino);
//		
//		if(!unidad.puedoMoverme(terrenoDestino))
//			return false;//destino invalido
//		if(coordenadaDestino.distanciaA(coordenadaOrigen) > unidad.getMovimientos().actual())
//			return false;//fuera de rango
//		while(coordenadaDestino.distanciaA(coordenadaOrigen) > 1){
//			if(! this.darUnPaso(unidad,coordenadaOrigen,coordenadaDestino) )
//				return false;//no pudo llegar al destino, algo paso en el medio
//			else 
//				coordenadaOrigen = posiciones.get(unidad);//actualizo origen
//		}
//		
//		this.almacenar(unidad, coordenadaDestino);
//		
//		try {
//			terrenoOrigen.borrarContenido(unidad);
//		} catch (PropiedadNoExisteEnEstaUbicacion e) {
//			e.printStackTrace();
//		}
//		
//		unidad.getMovimientos().disminuir(coordenadaOrigen.distanciaA(coordenadaDestino));
//		
//		return true;
//	}
//	
//	private boolean darUnPaso(Unidad unidad, Coordenada origen, Coordenada destino) 
//			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException {
//		Coordenada mejorOpcion = origen ;
//		//entre los vecinos busco la mejor opcion
//		for(int x = origen.getX()-1 ; x <= origen.getX()+1 ; x++){
//			for(int y = origen.getY()-1 ; y <= origen.getY()+1 ; y++){
//				Coordenada candidata= new Coordenada(x,y);
//				if(this.hayCasillero(candidata)){
//					Terreno candidato = this.getTerreno(candidata);
//					if( ( candidato.getCoordenada().distanciaA(destino) < mejorOpcion.distanciaA(destino) )
//							&& unidad.puedoMoverme(candidato) )
//						mejorOpcion = candidata;
//				}
//			}
//		}
//		if (mejorOpcion == origen)
//			return false;//no hay mejor opcion que el lugar actual
//		else
//			return this.moverUnidad(unidad, mejorOpcion);
//	}
	
	
	//ataque
	
	public boolean gestionarAtaque(Unidad atacante, Propiedad atacado) throws PropiedadNoEstaEnJuegoException {
		Coordenada posicionAtacante = posiciones.get(atacante);
		Coordenada posicionAtacado = posiciones.get(atacado);
		
		if(posicionAtacante == null || posicionAtacado == null){
			throw new PropiedadNoEstaEnJuegoException();
		}
		
		int distanciaAtaque = posicionAtacante.distanciaA(posicionAtacado);
		
		boolean resultado = atacante.atacar(atacado, distanciaAtaque);
		if (atacado.estoyMuerto()){
			try {
				limpiarMuerto(atacado);
			} catch (FueraDeLimitesException e) {
				e.printStackTrace();//no deberia
			}
		}
		
		return resultado;
	}
	
	private void limpiarMuerto(Propiedad propiedad) 
			throws FueraDeLimitesException{
		Terreno terreno = this.getTerreno(posiciones.get(propiedad));
		
		try {
			terreno.borrarContenido(propiedad);
		} catch (PropiedadNoExisteEnEstaUbicacion e) {
			e.printStackTrace();
		}
		
		posiciones.remove(propiedad);
		
	}
	
	public int propiedadesEnJuego(){
		return posiciones.size();
	}
	
	public Collection<Terreno> obtenerRadioDeCasilleros(int radio, Coordenada centro){
		Collection<Terreno> outputTerrenos = new ArrayList<Terreno>();
		Iterator<Terreno> iter = this.iterator();
		
		while (iter.hasNext()){
			Terreno terrenoActual = iter.next();
			Coordenada coordenadaActual = terrenoActual.getCoordenada();
			if(coordenadaActual.distanciaA(centro) <= radio){
				outputTerrenos.add(terrenoActual);
			}
		}
		
		return outputTerrenos;
	}

}
