package algocraft.construcciones.protos;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;
import algocraft.unidades.protos.UnidadesProtos;

public class ArchivosTemplarios extends CreadorDeUnidades {
	
	private static final EnumEdificiosProtos nombreArchivosTemplarios = EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS;
	private static final UnidadesProtos nombreAltoTemplario= UnidadesProtos.ALTO_TEMPLARIO;
	private static final Recurso recursosNecesariosAltoTemplario = new Recurso(50,150);
	private static final int poblacionNecesariaAltoTemplario = 2;

	public ArchivosTemplarios() {
		super(new EdificioConEscudo(nombreArchivosTemplarios,500,9,500));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreAltoTemplario)	;
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreAltoTemplario)
			return this.crearUnidadEspecifica(nombreAltoTemplario, recursosNecesariosAltoTemplario, poblacionNecesariaAltoTemplario);
		return null;//lanzar excepcion?
			
	}

}
