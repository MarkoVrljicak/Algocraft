package algocraft.construccionesAlternativas.protos;

import algocraft.construccionesAlternativas.EdificioConEscudo;
import algocraft.construccionesAlternativas.EnumEdificiosProtos;

public class Pilon extends EdificioConEscudo{

	private static EnumEdificiosProtos nombrePilon = EnumEdificiosProtos.PILON;

	public Pilon() {
		super(nombrePilon,300,5,300);
	}
	
}
