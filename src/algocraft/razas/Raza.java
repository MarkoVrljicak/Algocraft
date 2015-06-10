package algocraft.razas;

import java.util.ArrayList;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.JugadorNulo;
import algocraft.jugador.Usuario;
import algocraft.stats.Recurso;

public abstract class Raza {

	protected EnumRazas nombre;
	protected ArrayList<EnumEdificios> construccionesCreables;
	protected Usuario duenio = new JugadorNulo();
	
	public Raza(){
		construccionesCreables= new ArrayList<EnumEdificios>();
		this.determinarCreables();
	}
	
	public EnumRazas getNombre(){
		return nombre;
	}
	
	public void setDuenio(Usuario jugador) {
		duenio = jugador;		
	}
	
	public ArrayList<EnumEdificios> getListaDeConstrucciones(){
		return construccionesCreables;
	}
	
	abstract protected void determinarCreables();//obligo a que determine creables en construccion
	abstract public Construccion crearConstruccion(EnumEdificios nombreEdificio);

	
	protected Construccion crearConstruccionEspecifico(EnumEdificios edificio, Recurso recursosNecesarios){
		
		if(puedoCrearConstruccion(recursosNecesarios) ){
			
			try {
				duenio.getRecursos().consumirMineral(recursosNecesarios.obtenerMineral());
				duenio.getRecursos().consumirGas(recursosNecesarios.obtenerGas());
			} catch (RecursosNegativosException e) {
				e.printStackTrace();
			}
			
			return edificio.crear();
		}
		else return null;
	}
	
	public boolean puedoCrearConstruccion(Recurso recursosNecesarios) {
		final Recurso recursosDisponibles = duenio.getRecursos();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerGas());
		
		return puedeCrearse;
	}
	
	public boolean tengoConstruccion(EnumEdificios nombreEdificio){
		return construccionesCreables.contains(nombreEdificio);
	}
}
