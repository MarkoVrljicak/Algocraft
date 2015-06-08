package algocraft.construccionesAlternativas.protos;

import algocraft.construccionesAlternativas.EdificioConEscudo;

public class BaseProtoss extends EdificioConEscudo {

	private static final EnumEdificiosProtos nombreBaseProtoss = EnumEdificiosProtos.BASE_PROTOSS;
	
	public BaseProtoss() {
		super(nombreBaseProtoss,1300,0,1200);
	}
}
