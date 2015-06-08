package algocraft.construccionesAlternativas;

public class CentroDeMineral extends RecolectorMineral{

	private static EdificiosTerran nombreCentroDeMineral = EdificiosTerran.CENTRO_DE_MINERALES;

	public CentroDeMineral() {
		super(new EdificioBasico(nombreCentroDeMineral,500,4));
	}
		
}
