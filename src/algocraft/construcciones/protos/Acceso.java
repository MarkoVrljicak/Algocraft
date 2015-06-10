package algocraft.construcciones.protos;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.protos.UnidadesProtos;

public class Acceso extends CreadorDeUnidades {
	
	private static final EnumEdificiosProtos nombreAcceso = EnumEdificiosProtos.ACCESO;
	private static final UnidadesProtos nombreZealot= UnidadesProtos.ZEALOT;
	private static final UnidadesProtos nombreDragon= UnidadesProtos.DRAGON;
	private static final Recurso recursosNecesariosZealot = new Recurso(100,0);
	private static final Recurso recursosNecesariosDragon = new Recurso(125,50);
	private static final int poblacionNecesariaZealot = 2;
	private static final int poblacionNecesariaDragon = 2;


	public Acceso() {
		super(new EdificioConEscudo(nombreAcceso,500,8,500));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreZealot);
		this.unidadesCreables.add(nombreDragon);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreZealot)
			return this.crearUnidadEspecifica(nombreZealot, recursosNecesariosZealot, poblacionNecesariaZealot);
		if(nombreUnidad==nombreDragon)
			return this.crearUnidadEspecifica(nombreDragon, recursosNecesariosDragon, poblacionNecesariaDragon);
		return null;//lanzar excepcion?
			
	}
}
