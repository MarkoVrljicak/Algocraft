package algocraft.construccionesAlternativas;

import stats.Poblacion;

public class AumentoDePoblacion extends DecoradorConstruccion{

	public AumentoDePoblacion(Construccion construccionDecorada) {
		super(construccionDecorada);
	}

	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
		aumentarPoblacion(this.edificio.getDuenio().getPoblacion());
	}

	public void aumentarPoblacion(Poblacion poblacion) {
		poblacion.incrementarMaxima(5);	
	}
	
}
