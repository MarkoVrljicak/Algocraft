package algocraft.construccionesAlternativas.terran;

import algocraft.construccionesAlternativas.EdificioBasico;
import algocraft.construccionesAlternativas.RecolectorGas;

public class Refineria extends RecolectorGas{

	private static EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;

	public Refineria() {
		super(new EdificioBasico(nombreRefineria,750,6));
	}
}
