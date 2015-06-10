package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorMineral extends DecoradorConstruccion{
	Construccion construccionDecorada;

	public RecolectorMineral(Construccion construccionDecorada) {
		super(construccionDecorada);
		this.construccionDecorada = construccionDecorada;
	}

	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
		recolectarMineral(this.getDuenio().getRecursos());
	}

	public void recolectarMineral(Recurso recursos) {
		recursos.incrementarMineral(10);		
	}
}
