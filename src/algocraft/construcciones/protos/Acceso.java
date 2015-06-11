package algocraft.construcciones.protos;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.protos.UnidadesProtos;

public class Acceso extends CreadorDeUnidades {
	
	
	private static final Recurso recursosNecesariosZealot = new Recurso(100,0);
	private static final Recurso recursosNecesariosDragon = new Recurso(125,50);
	private static final int poblacionNecesariaZealot = 2;
	private static final int poblacionNecesariaDragon = 2;


	public Acceso() {
		super(new EdificioConEscudo(EnumEdificiosProtos.ACCESO,500,8,500));
	}
	
	@Override
	protected void determinarCreables() {
		this.aniadirUnidadCreable(UnidadesProtos.ZEALOT);
		this.aniadirUnidadCreable(UnidadesProtos.DRAGON);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==UnidadesProtos.ZEALOT)
			return this.crearUnidadEspecifica(UnidadesProtos.ZEALOT, recursosNecesariosZealot, poblacionNecesariaZealot);
		if(nombreUnidad==UnidadesProtos.DRAGON)
			return this.crearUnidadEspecifica(UnidadesProtos.DRAGON, recursosNecesariosDragon, poblacionNecesariaDragon);
		return null;//lanzar excepcion?
			
	}
}
