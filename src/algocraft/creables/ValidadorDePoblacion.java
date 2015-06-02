package algocraft.creables;

import stats.Recurso;

public class ValidadorDePoblacion{
	
	protected int poblacionNecesaria= 0;
	protected ValidadorDeRecursos validadorRecursos;

	public ValidadorDePoblacion(Recurso recursosRequeridos,Creable creableAGuardar, int poblacionRequerida) {
		poblacionNecesaria=poblacionRequerida;
		validadorRecursos=new ValidadorDeRecursos(recursosRequeridos,creableAGuardar);
	}
	
	private boolean puedoCrearme(int poblacionDisponible) {
		return (poblacionDisponible>=poblacionNecesaria);
	}

	public Creable crear(Recurso recursosDisponibles, int poblacionDisponible) {
		if(this.puedoCrearme(poblacionDisponible))
			return validadorRecursos.crear(recursosDisponibles);
		else
			return null;
	}

}
