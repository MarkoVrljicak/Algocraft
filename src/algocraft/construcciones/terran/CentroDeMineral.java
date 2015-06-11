package algocraft.construcciones.terran;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.RecolectorMineral;

public class CentroDeMineral extends RecolectorMineral{

	

	public CentroDeMineral() {
		super(new EdificioBasico(EnumEdificiosTerran.CENTRO_DE_MINERALES,500,4));
	}
		
}
