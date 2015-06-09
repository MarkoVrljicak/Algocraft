package algocraft.construccionesAlternativas.protos;

import algocraft.construccionesAlternativas.EdificioConEscudo;
import algocraft.construccionesAlternativas.RecolectorGas;

public class Asimilador extends RecolectorGas{

	private static EnumEdificiosProtos nombreAsimilador = EnumEdificiosProtos.ASIMILADOR;

	public Asimilador() {
		super(new EdificioConEscudo(nombreAsimilador,450,6,450));
	}
	
}
