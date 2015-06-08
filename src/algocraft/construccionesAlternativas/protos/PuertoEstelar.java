package algocraft.construccionesAlternativas.protos;

import stats.Recurso;
import algocraft.construccionesAlternativas.CreadorDeUnidades;
import algocraft.construccionesAlternativas.EdificioConEscudo;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;
import algocraft.unidades.Alternativas.protos.UnidadesProtos;

public class PuertoEstelar extends CreadorDeUnidades {
	
	private static final EnumEdificiosProtos nombrePuertoEstelar = EnumEdificiosProtos.PUERTO_ESTELAR;
	private static final UnidadesProtos nombreScout= UnidadesProtos.SCOUT;
	private static final UnidadesProtos nombreNaveDeTransporte= UnidadesProtos.NAVE_DE_TRANSPORTE;
	private static final Recurso recursosNecesariosScout = new Recurso(300,150);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(200,0);
	private static final int poblacionNecesariaScout = 3;
	private static final int poblacionNecesariaNaveDeTransporte = 2;


	public PuertoEstelar() {
		super(new EdificioConEscudo(nombrePuertoEstelar,600,10,600));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreScout);
		this.unidadesCreables.add(nombreNaveDeTransporte);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreScout)
			return this.crearUnidadEspecifica(nombreScout, recursosNecesariosScout, poblacionNecesariaScout);
		if(nombreUnidad==nombreNaveDeTransporte)
			return this.crearUnidadEspecifica(nombreNaveDeTransporte, recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte);
		return null;//lanzar excepcion?
			
	}
	
}
