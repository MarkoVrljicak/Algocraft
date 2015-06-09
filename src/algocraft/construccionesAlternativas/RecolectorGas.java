package algocraft.construccionesAlternativas;

import Interfaces.Construccion;
import algocraft.ataques.Ataques;
import stats.Recurso;

public class RecolectorGas extends DecoradorConstruccion {
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
