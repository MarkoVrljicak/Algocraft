package algocraft.construcciones.protos;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.RecolectorGas;

public class Asimilador extends RecolectorGas{

	private static EnumEdificiosProtos nombreAsimilador = EnumEdificiosProtos.ASIMILADOR;

	public Asimilador() {
		super(new EdificioConEscudo(nombreAsimilador,450,6,450));
	}
	
}
