package algocraft.construcciones.terran;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.RecolectorGas;

public class Refineria extends RecolectorGas{

	private static EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;

	public Refineria() {
		super(new EdificioBasico(nombreRefineria,750,6));
	}
}
