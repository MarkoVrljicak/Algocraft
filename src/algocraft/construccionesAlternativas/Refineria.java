package algocraft.construccionesAlternativas;

public class Refineria extends RecolectorGas{

	private static EdificiosTerran nombreRefineria = EdificiosTerran.REFINERIA;

	public Refineria() {
		super(new EdificioBasico(nombreRefineria,750,6));
	}
}
