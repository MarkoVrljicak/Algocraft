package modelo.jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import modelo.Interfaces.Actualizable;
import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EnumEdificios;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.razas.CreadorDeEdificios;
import modelo.razas.CreadorDeEdificiosProtoss;
import modelo.razas.CreadorDeEdificiosTerran;
import modelo.razas.EnumRazas;
import modelo.stats.Recurso;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;

public class Jugador implements Actualizable, Usuario {
	
	private CreadorDeEdificios creadorEdificios;
	private ArrayList<Unidad> unidades;
	private ArrayList<Construccion> construcciones;
	private Recurso recursos;
	private Colores color;
	private String nombre;
	
	public Jugador(String nombreJugador, EnumRazas raza, Colores color){
		this.nombre = nombreJugador;
		this.color = color;
		this.creadorEdificios = elegirCreadorEdificios(raza);
		this.creadorEdificios.setDuenio(this);
		unidades = new ArrayList<Unidad>();
		recursos = new Recurso(200,0);
		construcciones = new ArrayList<Construccion>();
	}
	
	private CreadorDeEdificios elegirCreadorEdificios(EnumRazas raza){
		switch(raza){
		case PROTOSS:
			return new CreadorDeEdificiosProtoss();
		case TERRAN:
			return new CreadorDeEdificiosTerran();
		default:
			return new CreadorDeEdificiosTerran();
		}
		
	}
	
	//accesors 

	public String getNombre() {
		return this.nombre;
	}
	
	public EnumRazas getRaza(){
		return creadorEdificios.getNombre();
	}
	
	public int getMineral(){
		return recursos.obtenerMineral();
	}
	
	public int getGas(){
		return recursos.obtenerGas();
	}
	
	public void incrementarMineral(int cantidad){
		this.recursos.incrementarMineral(cantidad);
	}
	
	public void incrementarGas(int cantidad){
		this.recursos.incrementarGas(cantidad);
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
	
	public Set<EnumEdificios> getConstruccionesDisponibles(){
		return creadorEdificios.getListaDeConstrucciones();
	}
	
	public int cantidadConstrucciones() {
		return construcciones.size();
	}
	
	
	public int getPoblacionActual(){
		int poblacion = 0;
		Iterator<Unidad> itUnidades = unidades.iterator();
		while(itUnidades.hasNext()){
			Unidad unaUnidad = itUnidades.next();
			if (!unaUnidad.enConstruccion())
				poblacion += unaUnidad.getSuministros();
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
			 Construccion edificio = itConstrucciones.next();
			 poblacionMaxima += edificio.getPoblacionSumada();
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
	
	public Construccion construir(EnumEdificios nombreConstruccion) 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Construccion construccion = creadorEdificios.crearConstruccion(nombreConstruccion);
		construcciones.add(construccion);
	
		return construccion;
	}
	
	
	public Unidad crearUnidad(Unidades nombreUnidad , CreadorDeUnidades edificioCreador) 
			throws MineralInsuficienteException,GasInsuficienteException, PoblacionInsuficienteException {
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
