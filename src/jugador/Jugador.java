package jugador;

import java.util.ArrayList;
import java.util.Iterator;

import razasAlternativas.EnumRazas;
import razasAlternativas.Raza;
import stats.Poblacion;
import stats.Recurso;
import algocraft.construccionesAlternativas.Actualizable;
import algocraft.construccionesAlternativas.Construccion;
import algocraft.construccionesAlternativas.EnumEdificios;
import algocraft.unidades.Alternativas.Unidad;

public class Jugador implements Actualizable, Usuario {
	
	private Raza raza;
	
	@SuppressWarnings("unused")
	private ArrayList<Unidad> unidades;
	
	private ArrayList<Construccion> construcciones;
	private Recurso recursos;
	private Poblacion poblacion = new Poblacion();
	
	public Jugador(String nombreJugador, Raza razaSeleccionada){
		//falta color
		raza = razaSeleccionada;
		unidades = new ArrayList<Unidad>();
		recursos = new Recurso(200,0);
		construcciones = new ArrayList<Construccion>();
	}
	
	public Poblacion getPoblacion(){
		return poblacion;
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
	
	public void construir(EnumEdificios nombreConstruccion){
		Construccion construccion = raza.crearConstruccion(nombreConstruccion);
		construccion.setDuenio(this);
		construcciones.add(construccion);
	}

	public int cantidadConstrucciones() {
		return construcciones.size();
	}

	@Override
	public void pasarTurno() {
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			Actualizable unaConstruccion= (Actualizable) itConstrucciones.next();
			unaConstruccion.pasarTurno();
		}
	}

	
	@Override
	public boolean tieneConstruccion(String nombreConstruccion) {
		return false;
	}

	@Override
	public int getPoblacionDisponible() {
		return 0;//completar
	}
	
}
