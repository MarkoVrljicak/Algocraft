package algocraft.razas;

import java.util.HashMap;
import java.util.Set;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.exception.CondicionesInsuficientesException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.jugador.Jugador;
import algocraft.stats.Recurso;

public abstract class Raza {

	protected EnumRazas nombre;
	protected HashMap<EnumEdificios, EdificiosAbstractFactory> construccionesCreables;
	protected Jugador duenio;
	
	//metodos de inicializacion
	protected Raza(){
		construccionesCreables = new HashMap<EnumEdificios, EdificiosAbstractFactory>();
		this.determinarCreables();
	}
	
	abstract protected void determinarCreables();
	
	protected void aniadirEdificioCreable(EnumEdificios nombreEdificio, EdificiosAbstractFactory creador){
		this.construccionesCreables.put(nombreEdificio, creador);
	}
	
	//accessors
	
	public EnumRazas getNombre(){
		return nombre;
	}
	
	public void setDuenio(Jugador jugador) {
		duenio = jugador;		
	}
	
	public Set<EnumEdificios> getListaDeConstrucciones(){
		return construccionesCreables.keySet();
	}
	
	public boolean tengoConstruccion(EnumEdificios nombreEdificio){
		return construccionesCreables.containsKey(nombreEdificio);
	}
	
	public Construccion crearConstruccion(EnumEdificios nombreEdificio) throws CondicionesInsuficientesException{
		EdificiosAbstractFactory creador = construccionesCreables.get(nombreEdificio);
		
		if(puedoCrearConstruccion(creador) ){
			
			try {
				duenio.consumirMineral(creador.getMineralNecesario());
				duenio.consumirGas(creador.getGasNecesario());
			} catch (RecursosNegativosException e) {
				throw new CondicionesInsuficientesException();
			}
			
			Construccion edificio = creador.crearEdificio();
			edificio.setDuenio(duenio);
			return edificio;
		}
		else 
			throw new CondicionesInsuficientesException();
	}
	
	//creacion edificios
	public boolean puedoCrearConstruccion(EdificiosAbstractFactory creador) {
		final Recurso recursosDisponibles = duenio.getRecursos();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= creador.getMineralNecesario());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= creador.getGasNecesario());
		
		if(creador.necesitoConstruccionAnterior()){
			puedeCrearse = puedeCrearse && (duenio.tieneConstruccion(creador.getConstruccionNecesitada()));
		}
		
		return puedeCrearse;
	}	
		
}
