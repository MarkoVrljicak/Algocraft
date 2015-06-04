package algocraft.construccionesAlternativas;

import stats.Recurso;

public class RecolectorMineral extends DecoradorConstruccion{

	public RecolectorMineral(Construccion construccionDecorada) {
		super(construccionDecorada);
	}

	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
		//recolectarMineral(this.getDuenio().getRecursos());activar cuando un test lo pida
	}

	public void recolectarMineral(Recurso recursos) {
		recursos.incrementarMineral(10);		
	}

}
