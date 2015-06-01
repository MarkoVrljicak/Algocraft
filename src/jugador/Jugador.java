package jugador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import algocraft.construcciones.Construccion;
import algocraft.unidades.Unidad;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private ArrayList<Unidad> unidades;
	private ArrayList<Construccion> construcciones;
	private HashMap<String, Integer> recursos; //el generico no puede ser int porque es un tipo primitivo.
	
	public Jugador(String nombreJugador, Raza razaSeleccionada){
		//falta color
		raza = razaSeleccionada;
		unidades = new ArrayList<Unidad>();
		recursos = new HashMap<String, Integer>();
		construcciones = new ArrayList<Construccion>();
		recursos.put("mineral", 200);
		recursos.put("gas", 0);
	}
	
	public int poblacion(){
		return unidades.size();
	}
	
	public String getRaza(){
		return raza.getNombre();
	}
	
	public Collection<String> getConstruccionesDisponibles(){
		return raza.getListaDeConstrucciones();
	}
	
	public int getMineral(){
		return recursos.get("mineral").intValue();
	}
	
	public int getGas(){
		return recursos.get("gas").intValue();
	}
	
	public void construir(String nombreConstruccion){
		Construccion construccion = raza.construirConstruccion(this.getMineral(), this.getGas(), nombreConstruccion);
		construcciones.add(construccion);
	}

	public int cantidadConstrucciones() {
		return construcciones.size();
	}
}
