package algocraft.construcciones.protos;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.protos.UnidadesProtos;

public class ArchivosTemplarios extends CreadorDeUnidades {
	
	
	private static final Recurso recursosNecesariosAltoTemplario = new Recurso(50,150);
	private static final int poblacionNecesariaAltoTemplario = 2;

	public ArchivosTemplarios() {
		super(new EdificioConEscudo(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS,500,9,500));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(UnidadesProtos.ALTO_TEMPLARIO)	;
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==UnidadesProtos.ALTO_TEMPLARIO)
			return this.crearUnidadEspecifica(UnidadesProtos.ALTO_TEMPLARIO, 
					recursosNecesariosAltoTemplario, poblacionNecesariaAltoTemplario);
		return null;//lanzar excepcion?
			
	}

}
