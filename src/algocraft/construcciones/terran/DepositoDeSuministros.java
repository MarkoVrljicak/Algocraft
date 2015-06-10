package algocraft.construcciones.terran;

import algocraft.construcciones.EdificioBasico;

public class DepositoDeSuministros extends EdificioBasico{

	private static EnumEdificiosTerran nombreDepositoDeSuministros = EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS;

	public DepositoDeSuministros() {
		super(nombreDepositoDeSuministros,500,6);
	}
}
