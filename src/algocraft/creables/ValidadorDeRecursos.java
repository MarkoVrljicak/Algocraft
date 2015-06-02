package algocraft.creables;

import stats.Recurso;

public class ValidadorDeRecursos {

	protected Recurso recursosNecesarios;
	protected Creable creable;

	public ValidadorDeRecursos(Recurso recursosRequeridos,Creable creableAGuardar) {
		recursosNecesarios = new Recurso(recursosRequeridos.obtenerMineral(),
				recursosRequeridos.obtenerGas());
		creable = creableAGuardar;
	}

	public String getNombreCreable() {
		return creable.getNombre();
	}

	private boolean puedoCrearme(Recurso recursosDisponibles) {
		return ( ( recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral() ) && 
				 ( recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerGas() ) );
	}

	public Creable crear(Recurso recursosDisponibles) {
		if (this.puedoCrearme(recursosDisponibles)) {
			return creable.clonar();
		} else {
			return null;
		}
	}
}
