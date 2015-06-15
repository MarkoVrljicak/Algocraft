package algocraft.jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import algocraft.Interfaces.Actualizable;
import algocraft.Interfaces.Daniable;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EnumEdificios;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
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
	
	//accesors 
	
	public EnumRazas getRaza(){
		return raza.getNombre();
	}
	
	
	public Set<EnumEdificios> getConstruccionesDisponibles(){
		return raza.getListaDeConstrucciones();
	}
	
	
	public Recurso getRecursos(){
		return recursos;
	}
	
	public void consumirMineral(int cantidad) throws RecursosNegativosException{
		this.recursos.consumirMineral(cantidad);
	}
	
	public void consumirGas(int cantidad) throws RecursosNegativosException{
		this.recursos.consumirGas(cantidad);
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
	
	//de creacion
	
	public Construccion construir(EnumEdificios nombreConstruccion){
		Construccion construccion = raza.crearConstruccion(nombreConstruccion);
		if(!(construccion == null) ){
			construcciones.add(construccion);
		}
		return construccion;
	}
	
	
	public Unidad crearUnidad(Unidades nombreUnidad , CreadorDeUnidades edificioCreador) {
		Unidad unidadCreada = null;
		unidadCreada = edificioCreador.crearUnidad(nombreUnidad);
		if(!(unidadCreada == null)){
			unidades.add( unidadCreada );
		}
		return unidadCreada;
	}

	//actualizacion
	
	@Override
	public void iniciarTurno() {
		
		this.limpiarMuertos();
		//inicio construcciones
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			itConstrucciones.next().iniciarTurno();;
		}
		//inicio unidades
		Iterator<Unidad> itUnidades= unidades.iterator();	
		while(itUnidades.hasNext()){
			itUnidades.next().iniciarTurno();
		}
	}


	private void limpiarMuertos() {
		//limpio construcciones
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			Daniable unaConstruccion=  itConstrucciones.next();
			if (unaConstruccion.estoyMuerto()){
				construcciones.remove(unaConstruccion);
				itConstrucciones= construcciones.iterator();				
			}
		}
		//limpio unidades
		Iterator<Unidad> itUnidades = unidades.iterator();
		while(itUnidades.hasNext()){
			Daniable unaUnidad = itUnidades.next();
			if (unaUnidad.estoyMuerto()){
				unidades.remove(unaUnidad);
				itUnidades = unidades.iterator();
			}
		}
	}
}
