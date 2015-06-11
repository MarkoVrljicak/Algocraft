package algocraft.construcciones.protos;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.protos.UnidadesProtos;

public class PuertoEstelar extends CreadorDeUnidades {
	
	
	private static final Recurso recursosNecesariosScout = new Recurso(300,150);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(200,0);
	private static final int poblacionNecesariaScout = 3;
	private static final int poblacionNecesariaNaveDeTransporte = 2;


	public PuertoEstelar() {
		super(new EdificioConEscudo(EnumEdificiosProtos.PUERTO_ESTELAR,600,10,600));
	}
	
	@Override
	protected void determinarCreables() {
		this.aniadirUnidadCreable(UnidadesProtos.SCOUT);
		this.aniadirUnidadCreable(UnidadesProtos.NAVE_DE_TRANSPORTE);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		
		if(nombreUnidad==UnidadesProtos.SCOUT)
			return this.crearUnidadEspecifica(UnidadesProtos.SCOUT, 
					recursosNecesariosScout, poblacionNecesariaScout);
		
		if(nombreUnidad==UnidadesProtos.NAVE_DE_TRANSPORTE)
			return this.crearUnidadEspecifica(UnidadesProtos.NAVE_DE_TRANSPORTE, 
					recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte);
		
		return null;//lanzar excepcion?
			
	}
	
}
