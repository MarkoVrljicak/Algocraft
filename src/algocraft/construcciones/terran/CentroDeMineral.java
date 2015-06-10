package algocraft.construcciones.terran;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.RecolectorMineral;

public class CentroDeMineral extends RecolectorMineral{

	private static EnumEdificiosTerran nombreCentroDeMineral = EnumEdificiosTerran.CENTRO_DE_MINERALES;

	public CentroDeMineral() {
		super(new EdificioBasico(nombreCentroDeMineral,500,4));
	}
		
}
