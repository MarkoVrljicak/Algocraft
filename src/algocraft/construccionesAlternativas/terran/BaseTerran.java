package algocraft.construccionesAlternativas.terran;

import algocraft.construccionesAlternativas.EdificioBasico;

public class BaseTerran extends EdificioBasico{
	
	private static EnumEdificiosTerran nombreBaseTerran = EnumEdificiosTerran.BASE_TERRAN;
	
	public BaseTerran(){
		super(nombreBaseTerran,2500,0);
	}

}
