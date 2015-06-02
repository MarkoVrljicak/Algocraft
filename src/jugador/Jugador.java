package jugador;

import java.util.ArrayList;
import java.util.Collection;
import algocraft.construcciones.Construccion;
import algocraft.unidades.Unidad;
import razas.Raza;
import stats.Recurso;

public class Jugador {
	
	private Raza raza;
	private ArrayList<Unidad> unidades;
	private ArrayList<Construccion> construcciones;
	private Recurso recursos;
	
	public Jugador(String nombreJugador, Raza razaSeleccionada){
		//falta color
		raza = razaSeleccionada;
		unidades = new ArrayList<Unidad>();
		recursos = new Recurso(200,0);
		construcciones = new ArrayList<Construccion>();
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
	//no se si lo puedo sacar
	public int getMineral(){
		return recursos.obtenerMineral();
	}
	//no se si lo puedo sacar
	public int getGas(){
		return recursos.obtenerGas();
	}
	
	public void construir(String nombreConstruccion){
		Construccion construccion = raza.construirConstruccion(this.recursos, nombreConstruccion);
		construcciones.add(construccion);
	}

	public int cantidadConstrucciones() {
		return construcciones.size();
	}
}
