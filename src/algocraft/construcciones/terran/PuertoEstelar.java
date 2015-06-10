package algocraft.construcciones.terran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.terran.UnidadesTerran;

public class PuertoEstelar extends CreadorDeUnidades {
	
	private static final EnumEdificiosTerran nombrePuertoEstelar = EnumEdificiosTerran.PUERTO_ESTELAR;
	private static final UnidadesTerran nombreEspectro = UnidadesTerran.ESPECTRO;
	private static final UnidadesTerran nombreNaveDeTransporte = UnidadesTerran.NAVE_TRANSPORTE;
	private static final UnidadesTerran nombreNaveDeCiencia = UnidadesTerran.NAVE_CIENCIA;
	private static final Recurso recursosNecesariosEspectro = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeCiencia = new Recurso(50,0);
	private static final int poblacionNecesariaEspectro = 1;
	private static final int poblacionNecesariaNaveDeTransporte = 1;
	private static final int poblacionNecesariaNaveDeCiencia = 1;

	public PuertoEstelar() {
		super(new EdificioBasico(nombrePuertoEstelar,1300,10));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreEspectro);
		this.unidadesCreables.add(nombreNaveDeTransporte);
		this.unidadesCreables.add(nombreNaveDeCiencia);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreEspectro)
			return this.crearUnidadEspecifica(nombreEspectro, recursosNecesariosEspectro, poblacionNecesariaEspectro);
		
		if(nombreUnidad==nombreNaveDeTransporte)
			return this.crearUnidadEspecifica(nombreNaveDeTransporte, recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte);
		
		if(nombreUnidad==nombreNaveDeCiencia)
			return this.crearUnidadEspecifica(nombreNaveDeCiencia, recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia);
		return null;//lanzar excepcion?
			
	}
}
