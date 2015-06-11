package algocraft.razas;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.stats.Recurso;

public class Protoss extends Raza{

	
	private static final Recurso recursosNecesariosAcceso = new Recurso(150,0);
	private static final Recurso recursosNecesariosBaseProtos = new Recurso(0,0);
	private static final Recurso recursosNecesariosArchivosTemplarios = new Recurso(150,200);
	private static final Recurso recursosNecesariosAsimilador = new Recurso(100,0);
	private static final Recurso recursosNecesariosNexoMineral = new Recurso(50,0);
	private static final Recurso recursosNecesariosPuertoEstelar = new Recurso(150,100);
	private static final Recurso recursosNecesariosPilon = new Recurso(100,0);
	
	public Protoss(){
		super();
		this.nombre = EnumRazas.PROTOSS;
	}
	
	@Override
	protected void determinarCreables() {
		this.aniadirEdificioCreable(EnumEdificiosProtos.ACCESO);
		this.aniadirEdificioCreable(EnumEdificiosProtos.BASE_PROTOSS);
		this.aniadirEdificioCreable(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS);
		this.aniadirEdificioCreable(EnumEdificiosProtos.ASIMILADOR);
		this.aniadirEdificioCreable(EnumEdificiosProtos.NEXO_MINERAL);
		this.aniadirEdificioCreable(EnumEdificiosProtos.PUERTO_ESTELAR);
		this.aniadirEdificioCreable(EnumEdificiosProtos.PILON);
		
	}

	@Override
	public Construccion crearConstruccion(EnumEdificios nombreEdificio) {
		
		if(nombreEdificio==EnumEdificiosProtos.ACCESO)
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.ACCESO, recursosNecesariosAcceso);
		
		if(nombreEdificio==EnumEdificiosProtos.BASE_PROTOSS)
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.BASE_PROTOSS, recursosNecesariosBaseProtos);
		
		if(nombreEdificio==EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS 
				&& this.duenio.tieneConstruccion(EnumEdificiosProtos.PUERTO_ESTELAR))
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS, 
					recursosNecesariosArchivosTemplarios);
		
		if(nombreEdificio==EnumEdificiosProtos.ASIMILADOR)
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.ASIMILADOR, recursosNecesariosAsimilador);
		
		if(nombreEdificio==EnumEdificiosProtos.NEXO_MINERAL)
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.NEXO_MINERAL, recursosNecesariosNexoMineral);
		
		if(nombreEdificio==EnumEdificiosProtos.PUERTO_ESTELAR 
				&& this.duenio.tieneConstruccion(EnumEdificiosProtos.ACCESO))
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.PUERTO_ESTELAR, recursosNecesariosPuertoEstelar);
		
		if(nombreEdificio==EnumEdificiosProtos.PILON)
			return this.crearConstruccionEspecifico(EnumEdificiosProtos.PILON, recursosNecesariosPilon);
		
		return null;
	}

}

