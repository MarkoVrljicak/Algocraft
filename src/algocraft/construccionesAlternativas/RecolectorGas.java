package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorGas extends DecoradorEdificioBasico {
	Construccion construccionDecorada;

	public RecolectorGas(Construccion construccionDecorada) {
		super(construccionDecorada);
		this.construccionDecorada = construccionDecorada;
	}

	@Override
	public void iniciarTurno() {
		this.edificio.iniciarTurno();
		recolectarGas(this.edificio.getDuenio().getRecursos());
	}

	public void recolectarGas(Recurso recursos) {
		recursos.incrementarGas(10);		
	}
	
}
