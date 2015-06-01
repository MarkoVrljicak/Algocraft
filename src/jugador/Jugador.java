package jugador;

import java.util.ArrayList;

import algocraft.unidades.Unidad;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private ArrayList<Unidad> unidades;
	
	public Jugador(String nombreJugador, Raza razaSeleccionada){
		//falta color
		raza = razaSeleccionada;
		unidades = raza.unidadesIniciales();
	}
	
	public int poblacion(){
		return unidades.size();
	}
}
