package algocraft.construcciones.protos;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.RecolectorGas;

public class Asimilador extends RecolectorGas{

	
	public Asimilador() {
		super(new EdificioConEscudo(EnumEdificiosProtos.ASIMILADOR,450,6,450));
	}
	
}
