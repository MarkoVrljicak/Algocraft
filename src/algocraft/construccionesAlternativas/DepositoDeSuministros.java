package algocraft.construccionesAlternativas;

public class DepositoDeSuministros extends AumentoDePoblacion{

	private static Edificios nombreDepositoDeSuministros = Edificios.DEPOSITO_DE_SUMINISTROS;

	public DepositoDeSuministros() {
		super(new EdificioBasico(nombreDepositoDeSuministros,500,6));
	}
}
