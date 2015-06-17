package algocraft.razas;

import algocraft.factory.edificiosProtoss.CreadorAcceso;
import algocraft.factory.edificiosProtoss.CreadorArchivosTemplarios;
import algocraft.factory.edificiosProtoss.CreadorAsimilador;
import algocraft.factory.edificiosProtoss.CreadorBaseProtoss;
import algocraft.factory.edificiosProtoss.CreadorNexoMineral;
import algocraft.factory.edificiosProtoss.CreadorPilon;
import algocraft.factory.edificiosProtoss.CreadorPuertoEstelar;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;

public class Protoss extends Raza{

	public Protoss(){
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

