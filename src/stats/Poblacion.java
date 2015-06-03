package stats;

public class Poblacion {

	private int poblacionMaxima=5;
	private int poblacionActual=0;

	public int maxima() {
		if(poblacionMaxima<=200)
			return poblacionMaxima;
		else
			return 200;
	}

	public void incrementarMaxima(int poblacionASumar) {
		poblacionMaxima+=poblacionASumar;
	}

	public int disponible() {
		return poblacionMaxima-poblacionActual;
	}

	public void incrementarActual(int poblacionASumar) {
		poblacionActual+=poblacionASumar;		
	}

	public int actual() {
		return poblacionActual;
	}

}
