package algocraft.construcciones.protos;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.RecolectorMineral;

public class NexoMineral extends RecolectorMineral{

	private static EnumEdificiosProtos nombreNexoMineral = EnumEdificiosProtos.NEXO_MINERAL;

	public NexoMineral() {
		super(new EdificioConEscudo(nombreNexoMineral,250,4,250));
	}

}
