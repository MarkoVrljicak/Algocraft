package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorGas extends DecoradorConstruccion {

	public RecolectorGas(Construccion construccionDecorada) {
		super(construccionDecorada);
	}

	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
		recolectarGas(this.edificio.getDuenio().getRecursos());
	}

	public void recolectarGas(Recurso recursos) {
		recursos.incrementarGas(10);		
	}

	
}
