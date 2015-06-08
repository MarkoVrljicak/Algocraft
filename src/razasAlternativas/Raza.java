package razasAlternativas;

import java.util.ArrayList;

import jugador.JugadorNulo;
import jugador.Usuario;
import stats.Recurso;
import algocraft.construccionesAlternativas.Construccion;
import algocraft.construccionesAlternativas.EnumEdificios;
import algocraft.exception.RecursosNegativosException;

public abstract class Raza {

	protected String nombre;
	protected ArrayList<EnumEdificios> construccionesCreables;
	protected Usuario duenio = new JugadorNulo();
	
	public Raza(){
		construccionesCreables= new ArrayList<EnumEdificios>();
		this.determinarCreables();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setDuenio(Usuario jugador) {
		duenio = jugador;		
	}
	
	abstract protected void determinarCreables();//obligo a que determine creables en construccion
	abstract public Construccion crearConstruccion(EnumEdificios nombreEdificio);

	
	public Construccion crearConstruccionEspecifico(EnumEdificios edificio, Recurso recursosNecesarios){
		
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
