package algocraft.construccionesAlternativas.protos;

import algocraft.construccionesAlternativas.EdificioConEscudo;
import algocraft.construccionesAlternativas.RecolectorGas;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;

public class Asimilador extends RecolectorGas{

	private static EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;

	public Asimilador() {
		super(new EdificioConEscudo(nombreRefineria,450,6,450));
	}
	
}
