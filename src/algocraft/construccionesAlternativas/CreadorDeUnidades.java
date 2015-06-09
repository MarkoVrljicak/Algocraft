package algocraft.construccionesAlternativas;


import java.util.ArrayList;

import stats.Recurso;
import algocraft.ataques.Ataques;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public abstract class CreadorDeUnidades extends DecoradorConstruccion {
	
	protected ArrayList<Unidades> unidadesCreables;
	Construccion construccionDecorada;
	
	public CreadorDeUnidades(Construccion construccionDecorada) {
		super(construccionDecorada);
		unidadesCreables= new ArrayList<Unidades>();
		this.determinarCreables();
		this.construccionDecorada = construccionDecorada;
	}

	abstract protected void determinarCreables();//obligo a que determine creables en construccion
	abstract public Unidad crearUnidad(Unidades nombreUnidad);

	
	public Unidad crearUnidadEspecifica(Unidades unidad, Recurso recursosNecesarios, int poblacionNecesaria){
		
		if(puedoCrearUnidad(recursosNecesarios, poblacionNecesaria) ){
			
			try {
				this.getDuenio().getRecursos().consumirMineral(recursosNecesarios.obtenerMineral());
				this.getDuenio().getRecursos().consumirGas(recursosNecesarios.obtenerGas());
			} catch (RecursosNegativosException e) {
				e.printStackTrace();
			}
			
			return unidad.crear();
		}
		else return null;
	}
	
	public boolean puedoCrearUnidad(Recurso recursosNecesarios,int poblacionNecesaria) {
		final Recurso recursosDisponibles = this.getDuenio().getRecursos();
		final int poblacionDisponible = this.getDuenio().getPoblacionDisponible();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerGas());
		puedeCrearse = puedeCrearse && (poblacionDisponible >= poblacionNecesaria);
		
		return puedeCrearse;
	}
	
	public boolean tengoUnidad(Unidades nombreUnidad){
		return unidadesCreables.contains(nombreUnidad);
	}
	
	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
	}	
	
	@Override
	public void recibirDanio(int cantidadDanio) {
		construccionDecorada.recibirDanio(cantidadDanio);
		
	}

	@Override
	public Ataques comoAtacarme() {
		return Ataques.ATAQUE_NORMAL_TERRESTRE;
	}

	@Override
	public boolean estoyMuerto() {
		return construccionDecorada.estoyMuerto();
	}
}
