package modelo.razas;

import modelo.factory.edificiosProtoss.CreadorAcceso;
import modelo.factory.edificiosProtoss.CreadorArchivosTemplarios;
import modelo.factory.edificiosProtoss.CreadorAsimilador;
import modelo.factory.edificiosProtoss.CreadorBaseProtoss;
import modelo.factory.edificiosProtoss.CreadorNexoMineral;
import modelo.factory.edificiosProtoss.CreadorPilon;
import modelo.factory.edificiosProtoss.CreadorPuertoEstelar;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;

public class CreadorDeEdificiosProtoss extends CreadorDeEdificios{

	public CreadorDeEdificiosProtoss(){
		super();
		this.nombre = EnumRazas.PROTOSS;
	}
	
	@Override
	protected void determinarCreables() {
		this.aniadirEdificioCreable(EnumEdificiosProtos.ACCESO, new CreadorAcceso());
		this.aniadirEdificioCreable(EnumEdificiosProtos.BASE_PROTOSS, new CreadorBaseProtoss());
		this.aniadirEdificioCreable(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS, new CreadorArchivosTemplarios());
		this.aniadirEdificioCreable(EnumEdificiosProtos.ASIMILADOR, new CreadorAsimilador());
		this.aniadirEdificioCreable(EnumEdificiosProtos.NEXO_MINERAL, new CreadorNexoMineral());
		this.aniadirEdificioCreable(EnumEdificiosProtos.PUERTO_ESTELAR, new CreadorPuertoEstelar());
		this.aniadirEdificioCreable(EnumEdificiosProtos.PILON, new CreadorPilon());
		
	}

}

