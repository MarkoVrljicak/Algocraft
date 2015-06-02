package algocraft.creables;

import stats.Recurso;

public class ValidadorDeCreaciones {

	protected Recurso recursosNecesarios;
	protected Creable creable;

	public ValidadorDeCreaciones(Recurso recursosRequeridos,Creable creableAGuardar) {
		recursosNecesarios = new Recurso(recursosRequeridos.obtenerMineral(),
				recursosRequeridos.obtenerGas());
		creable = creableAGuardar;
	}

	public String getNombreCreable() {
		return creable.getNombre();
	}

	private boolean puedoCrearme(Recurso recursosDisponibles) {
		return ( ( recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral() ) && 
				 ( recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerMineral() ) );
	}

	public Creable crear(Recurso recursosDisponibles) {
		if (this.puedoCrearme(recursosDisponibles)) {
			return creable.clonar();
		} else {
			return null;
		}
	}
}
