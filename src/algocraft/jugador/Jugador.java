package algocraft.jugador;

import java.util.ArrayList;
import java.util.Iterator;

import algocraft.Interfaces.Actualizable;
import algocraft.Interfaces.Daniable;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.construcciones.terran.EnumEdificiosTerran;
import algocraft.razas.EnumRazas;
import algocraft.razas.Raza;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;

public class Jugador implements Actualizable, Usuario {
	
	private Raza raza;
	private ArrayList<Unidad> unidades;
	private ArrayList<Construccion> construcciones;
	private Recurso recursos;
	private Colores color;
	
	public Jugador(String nombreJugador, Raza raza, Colores color){
		this.color = color;
		this.raza = raza;
		this.raza.setDuenio(this);
		unidades = new ArrayList<Unidad>();
		recursos = new Recurso(200,0);
		construcciones = new ArrayList<Construccion>();
	}
	
	
	public EnumRazas getRaza(){
		return raza.getNombre();
	}
	
	
	public ArrayList<EnumEdificios> getConstruccionesDisponibles(){
		return raza.getListaDeConstrucciones();
	}
	
	
	public Recurso getRecursos(){
		return recursos;
	}
	
	
	public Colores getColor(){
		return color;
	}
	
	
	public int cantidadConstrucciones() {
		return construcciones.size();
	}
	
	
	public int getPoblacionActual(){
		int poblacion = 0;
		Iterator<Unidad> itUnidades = unidades.iterator();
		while(itUnidades.hasNext()){
			poblacion += itUnidades.next().getSuministros();
		}
		return poblacion;
	}
	
	public int getPoblacionMaxima() {
		final int topePoblacional = 200 ;
		//empieza en cinco
		int poblacionMaxima = 5;
		//recorro construcciones, pilon y deposito suman poblacion maxima
		Iterator<Construccion> itConstrucciones = construcciones.iterator();
		while(itConstrucciones.hasNext()){
			 EnumEdificios nombre = itConstrucciones.next().getNombre();
			 if(nombre == EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS)
				 poblacionMaxima += 5;
			 if(nombre == EnumEdificiosProtos.PILON)
				 poblacionMaxima += 5;
		}
		if(poblacionMaxima<=topePoblacional)
			return poblacionMaxima;
		else return topePoblacional ;
	}	
	
	@Override
	public int getPoblacionDisponible() {
		return this.getPoblacionMaxima()-this.getPoblacionActual();
	}
	
	
	@Override
	public boolean tieneConstruccion(EnumEdificios nombreEdificio) {
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			if(itConstrucciones.next().getNombre() == nombreEdificio)
				return true;
		}
		return false;//si no lo tiene
	}
	
	
	public Construccion construir(EnumEdificios nombreConstruccion){
		Construccion construccion = raza.crearConstruccion(nombreConstruccion);
		if(!(construccion == null) ){
			construccion.setDuenio(this);
			construcciones.add(construccion);
		}
		return construccion;
	}
	
	
	public Unidad crearUnidad(Unidades nombreUnidad , CreadorDeUnidades edificioCreador) {
		Unidad unidadCreada = null;
		if(edificioCreador.puedoCrearUnidad(this.getRecursos(),this.getPoblacionDisponible())){
			unidadCreada = edificioCreador.crearUnidad(nombreUnidad);
			unidades.add( unidadCreada );
		}
		return unidadCreada;
	}

	
	@Override
	public void iniciarTurno() {
		
		this.limpiarMuertos();
		//inicio construcciones
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			Actualizable unaConstruccion= (Actualizable) itConstrucciones.next();
			unaConstruccion.iniciarTurno();
		}
	}


	private void limpiarMuertos() {
		//limpio construcciones
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			Daniable unaConstruccion= (Daniable) itConstrucciones.next();
			if (unaConstruccion.estoyMuerto()){
				construcciones.remove(unaConstruccion);
				itConstrucciones= construcciones.iterator();				
			}
		}
		//limpio unidades
		Iterator<Unidad> itUnidades = unidades.iterator();
		while(itUnidades.hasNext()){
			Daniable unaUnidad =(Daniable) itUnidades.next();
			if (unaUnidad.estoyMuerto()){
				unidades.remove(unaUnidad);
				itUnidades = unidades.iterator();
			}
		}
	}
}
