package algocraft;

public class PuertoEstelar extends Construccion {

	public PuertoEstelar() {
		this.vidamaxima.setVida(1300);
		this.costomineral = 150;
		this.costogas = 100;
	}

	public Espectro crearEspectro() {
		return new Espectro();
	}

	public NaveCiencia crearNaveCiencia() {
		return new NaveCiencia();
	}

	public NaveTransporte crearNaveTransporte() {
		return new NaveTransporte();
	}
}
