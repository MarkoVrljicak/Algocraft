package algocraft.construccionesAlternativas.protos;

import algocraft.construccionesAlternativas.EdificioConEscudo;
import algocraft.construccionesAlternativas.RecolectorMineral;

public class NexoMineral extends RecolectorMineral{

	private static EnumEdificiosProtos nombreNexoMineral = EnumEdificiosProtos.NEXO_MINERAL;

	public NexoMineral() {
		super(new EdificioConEscudo(nombreNexoMineral,250,4,250));
	}

}
