package algocraft.construccionesAlternativas;

import algocraft.ataques.Ataques;
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

	@Override
	public void recibirDanio(int cantidadDanio) {
		construccionDecorada.recibirDanio(cantidadDanio);
	}

	@Override
	public Ataques comoAtacarme() {
		return Ataques.ATAQUE_NORMAL_TERRESTRE;
	}

	@Override
	public boolean estoyMuerto() {
		return construccionDecorada.estoyMuerto();
	}

}
