package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorGas extends DecoradorEdificioBasico {
	Construccion construccionDecorada;

	public RecolectorGas(Construccion construccionDecorada) {
		super(construccionDecorada);
		this.construccionDecorada = construccionDecorada;
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
