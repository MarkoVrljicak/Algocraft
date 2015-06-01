package jugador;

import java.util.ArrayList;
import java.util.Collection;

import algocraft.unidades.Unidad;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private ArrayList<Unidad> unidades;
	
	public Jugador(String nombreJugador, Raza razaSeleccionada){
		//falta color
		raza = razaSeleccionada;
		unidades = new ArrayList<Unidad>();
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
}
