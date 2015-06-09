package jugador;

import java.util.ArrayList;
import java.util.Iterator;

import razasAlternativas.EnumRazas;
import razasAlternativas.Raza;
import stats.Recurso;
import algocraft.construccionesAlternativas.Actualizable;
import algocraft.construccionesAlternativas.Construccion;
import algocraft.construccionesAlternativas.EnumEdificios;
import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import algocraft.unidades.Alternativas.Unidad;

public class Jugador implements Actualizable, Usuario {
	
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
	
	public int getPoblacionMaxima() {
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
		return poblacionMaxima;
	}	
	
	public int getPoblacionActual(){
		int poblacion = 0;
		Iterator<Unidad> itUnidades = unidades.iterator();
		while(itUnidades.hasNext()){
			poblacion += itUnidades.next().getSuministros();
		}
		return poblacion;
	}
	
	@Override
	public int getPoblacionDisponible() {
		return this.getPoblacionMaxima()-this.getPoblacionActual();
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
}
