package algocraft.construccionesAlternativas;

public class Refineria extends RecolectorGas{

	private static Edificios nombreRefineria = Edificios.REFINERIA;

	public Refineria() {
		super(new EdificioBasico(nombreRefineria,750,6));
	}
}
