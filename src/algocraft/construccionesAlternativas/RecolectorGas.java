package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorGas extends DecoradorEdificioBasico {

	public RecolectorGas(Construccion construccionDecorada) {
		super(construccionDecorada);
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
