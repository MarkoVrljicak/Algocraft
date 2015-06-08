package algocraft.construccionesAlternativas.terran;

import algocraft.construccionesAlternativas.EdificioBasico;
import algocraft.construccionesAlternativas.EnumEdificiosTerran;

public class DepositoDeSuministros extends EdificioBasico{

	private static EnumEdificiosTerran nombreDepositoDeSuministros = EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS;

	public DepositoDeSuministros() {
		super(nombreDepositoDeSuministros,500,6);
	}
}
