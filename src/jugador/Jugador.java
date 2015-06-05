package jugador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import algocraft.construcciones.Actualizable;
import algocraft.construcciones.Construccion;
import algocraft.unidades.Unidad;
import razas.Raza;
import stats.Poblacion;
import stats.Recurso;

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
	
	public String getRaza(){
		return raza.getNombre();
	}
	
	public Collection<String> getConstruccionesDisponibles(){
		return raza.getListaDeConstrucciones();
	}
	
	public Recurso getRecursos(){
		return recursos;
	}
	
	
	public void construir(String nombreConstruccion){
		Construccion construccion = raza.construirConstruccion(this.recursos, nombreConstruccion);
		construccion.setDuenio(this);
		construcciones.add(construccion);
	}

	public int cantidadConstrucciones() {
		return construcciones.size();
	}

	@Override
	public void actualizar() {
		Iterator<Construccion> itConstrucciones= construcciones.iterator();	
		while(itConstrucciones.hasNext()){
			Actualizable unaConstruccion= (Actualizable) itConstrucciones.next();
			unaConstruccion.actualizar();
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
