package algocraft.razas;

import java.util.HashMap;
import java.util.Set;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.CreadorDeEdificios;
import algocraft.jugador.JugadorNulo;
import algocraft.jugador.Usuario;
import algocraft.stats.Recurso;

public abstract class Raza {

	protected EnumRazas nombre;
	protected HashMap<EnumEdificios, CreadorDeEdificios> construccionesCreables;
	protected Usuario duenio = new JugadorNulo();
	
	//metodos de inicializacion
	public Raza(){
		construccionesCreables = new HashMap<EnumEdificios, CreadorDeEdificios>();
		this.determinarCreables();
	}
	
	abstract protected void determinarCreables();
	
	protected void aniadirEdificioCreable(EnumEdificios nombreEdificio, CreadorDeEdificios creador){
		this.construccionesCreables.put(nombreEdificio, creador);
	}
	
	//accessors
	
	public EnumRazas getNombre(){
		return nombre;
	}
	
	public void setDuenio(Usuario jugador) {
		duenio = jugador;		
	}
	
	public Set<EnumEdificios> getListaDeConstrucciones(){
		return construccionesCreables.keySet();
	}
	
	public boolean tengoConstruccion(EnumEdificios nombreEdificio){
		return construccionesCreables.containsKey(nombreEdificio);
	}
	
	public Construccion crearConstruccion(EnumEdificios nombreEdificio){
		CreadorDeEdificios creador = construccionesCreables.get(nombreEdificio);
		
		if(puedoCrearConstruccion(creador) ){
			
			try {
				duenio.getRecursos().consumirMineral(creador.getRecursosNecesarios().obtenerMineral());
				duenio.getRecursos().consumirGas(creador.getRecursosNecesarios().obtenerGas());
			} catch (RecursosNegativosException e) {
				e.printStackTrace();
			}
			
			return creador.crearEdificio();
		}
		else return null;
	}
	
	//creacion edificios
	public boolean puedoCrearConstruccion(CreadorDeEdificios creador) {
		final Recurso recursosDisponibles = duenio.getRecursos();
		final Recurso recursosNecesarios = creador.getRecursosNecesarios();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerGas());
		
		if(creador.necesitoConstruccionAnterior()){
			puedeCrearse = puedeCrearse && (duenio.tieneConstruccion(creador.getConstruccionNecesitada()));
		}
		
		return puedeCrearse;
	}	
		
}
