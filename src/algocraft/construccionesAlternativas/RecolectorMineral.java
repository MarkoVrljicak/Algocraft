package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorMineral extends DecoradorEdificioBasico{
	Construccion construccionDecorada;

	public RecolectorMineral(Construccion construccionDecorada) {
		super(construccionDecorada);
		this.construccionDecorada = construccionDecorada;
	}

	@Override
	public void iniciarTurno() {
		this.edificio.iniciarTurno();
		recolectarMineral(this.getDuenio().getRecursos());
	}

	public void recolectarMineral(Recurso recursos) {
		recursos.incrementarMineral(10);		
	}
}
