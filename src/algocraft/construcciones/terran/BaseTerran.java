package algocraft.construcciones.terran;

import algocraft.construcciones.EdificioBasico;

public class BaseTerran extends EdificioBasico{
	
	private static EnumEdificiosTerran nombreBaseTerran = EnumEdificiosTerran.BASE_TERRAN;
	
	public BaseTerran(){
		super(nombreBaseTerran,2500,0);
	}

}
