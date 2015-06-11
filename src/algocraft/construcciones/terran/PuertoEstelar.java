package algocraft.construcciones.terran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.terran.UnidadesTerran;

public class PuertoEstelar extends CreadorDeUnidades {
	
	private static final Recurso recursosNecesariosEspectro = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeCiencia = new Recurso(50,0);
	private static final int poblacionNecesariaEspectro = 1;
	private static final int poblacionNecesariaNaveDeTransporte = 1;
	private static final int poblacionNecesariaNaveDeCiencia = 1;

	public PuertoEstelar() {
		super(new EdificioBasico(EnumEdificiosTerran.PUERTO_ESTELAR,1300,10));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(UnidadesTerran.ESPECTRO);
		this.unidadesCreables.add(UnidadesTerran.NAVE_TRANSPORTE);
		this.unidadesCreables.add(UnidadesTerran.NAVE_CIENCIA);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==UnidadesTerran.ESPECTRO)
			return this.crearUnidadEspecifica(UnidadesTerran.ESPECTRO, 
					recursosNecesariosEspectro, poblacionNecesariaEspectro);
		
		if(nombreUnidad==UnidadesTerran.NAVE_TRANSPORTE)
			return this.crearUnidadEspecifica(UnidadesTerran.NAVE_TRANSPORTE, 
					recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte);
		
		if(nombreUnidad==UnidadesTerran.NAVE_CIENCIA)
			return this.crearUnidadEspecifica(UnidadesTerran.NAVE_CIENCIA, 
					recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia);
		
		return null;//lanzar excepcion?
			
	}
}
