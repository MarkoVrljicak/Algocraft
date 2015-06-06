package algocraft.construccionesAlternativas;

public class CentroDeMineral extends RecolectorMineral{

	private static Edificios nombreCentroDeMineral = Edificios.CENTRO_DE_MINERALES;

	public CentroDeMineral() {
		super(new EdificioBasico(nombreCentroDeMineral,500,4));
	}
		
}
