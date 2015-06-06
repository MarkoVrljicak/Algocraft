package algocraft.construccionesAlternativas;


import java.util.ArrayList;

import stats.Recurso;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public abstract class CreadorDeUnidades extends DecoradorConstruccion {
	
	protected ArrayList<Unidades> unidadesCreables;
	
	public CreadorDeUnidades(Construccion construccionDecorada) {
		super(construccionDecorada);
		unidadesCreables= new ArrayList<Unidades>();
		this.determinarCreables();
	}

	abstract protected void determinarCreables();//obligo a que determine creables en construccion
	abstract public Unidad crearUnidad(Unidades nombreUnidad);

	
	public Unidad crearUnidadEspecifica(Unidades nombre, int vida, Recurso recursosNecesarios, int poblacionNecesaria){
		
		if(puedoCrearUnidad(recursosNecesarios, poblacionNecesaria) ){
			
			try {
				this.getDuenio().getRecursos().consumirMineral(recursosNecesarios.obtenerMineral());
				this.getDuenio().getRecursos().consumirGas(recursosNecesarios.obtenerGas());
			} catch (RecursosNegativosException e) {
				e.printStackTrace();
			}
			
			return new Unidad(nombre,vida);
		}
		else return null;
	}
	
	public boolean puedoCrearUnidad(Recurso recursosNecesarios,int poblacionNecesaria) {
		final Recurso recursosDisponibles = this.getDuenio().getRecursos();
		final int poblacionDisponible = this.getDuenio().getPoblacion().disponible();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerGas());
		puedeCrearse = puedeCrearse && (poblacionDisponible >= poblacionNecesaria);
		
		return puedeCrearse;
	}
	
	public boolean tengoUnidad(Unidades nombreUnidad){
		return unidadesCreables.contains(nombreUnidad);
	}
}
