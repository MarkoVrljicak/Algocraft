package algocraft.construcciones.terran;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.RecolectorGas;

public class Refineria extends RecolectorGas{

	

	public Refineria() {
		super(new EdificioBasico(EnumEdificiosTerran.REFINERIA,750,6));
	}
}
