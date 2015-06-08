package algocraft.construccionesAlternativas.terran;

import algocraft.construccionesAlternativas.EdificioBasico;
import algocraft.construccionesAlternativas.EnumEdificiosTerran;
import algocraft.construccionesAlternativas.RecolectorMineral;

public class CentroDeMineral extends RecolectorMineral{

	private static EnumEdificiosTerran nombreCentroDeMineral = EnumEdificiosTerran.CENTRO_DE_MINERALES;

	public CentroDeMineral() {
		super(new EdificioBasico(nombreCentroDeMineral,500,4));
	}
		
}
