package algocraft.construcciones.protos;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.RecolectorMineral;

public class NexoMineral extends RecolectorMineral{

	

	public NexoMineral() {
		super(new EdificioConEscudo(EnumEdificiosProtos.NEXO_MINERAL,250,4,250));
	}

}
