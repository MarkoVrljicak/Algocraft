package algocraft.construccionesAlternativas.protos;

import algocraft.construccionesAlternativas.EdificioConEscudo;
import algocraft.construccionesAlternativas.EnumEdificiosTerran;
import algocraft.construccionesAlternativas.RecolectorGas;

public class Asimilador extends RecolectorGas{

	private static EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;

	public Asimilador() {
		super(new EdificioConEscudo(nombreRefineria,450,6,450));
	}
	
}
