package algocraft.razas;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.stats.Recurso;

public class Protoss extends Raza{

	private static final EnumEdificiosProtos nombreAcceso= EnumEdificiosProtos.ACCESO;
	private static final EnumEdificiosProtos nombreBaseProtos= EnumEdificiosProtos.BASE_PROTOSS;
	private static final EnumEdificiosProtos nombreArchivosTemplarios= EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS;
	private static final EnumEdificiosProtos nombreAsimilador= EnumEdificiosProtos.ASIMILADOR;
	private static final EnumEdificiosProtos nombreNexoMineral= EnumEdificiosProtos.NEXO_MINERAL;
	private static final EnumEdificiosProtos nombrePuertoEstelar= EnumEdificiosProtos.PUERTO_ESTELAR;
	private static final EnumEdificiosProtos nombrePilon= EnumEdificiosProtos.PILON;
	private static final Recurso recursosNecesariosAcceso = new Recurso(150,0);
	private static final Recurso recursosNecesariosBaseProtos = new Recurso(0,0);
	private static final Recurso recursosNecesariosArchivosTemplarios = new Recurso(150,200);
	private static final Recurso recursosNecesariosAsimilador = new Recurso(100,0);
	private static final Recurso recursosNecesariosNexoMineral = new Recurso(50,0);
	private static final Recurso recursosNecesariosPuertoEstelar = new Recurso(150,100);
	private static final Recurso recursosNecesariosPilon = new Recurso(100,0);
	
	public Protoss(){
		this.nombre = EnumRazas.PROTOSS;
	}
	
	@Override
	protected void determinarCreables() {
		this.construccionesCreables.add(nombreAcceso);
		this.construccionesCreables.add(nombreBaseProtos);
		this.construccionesCreables.add(nombreArchivosTemplarios);
		this.construccionesCreables.add(nombreAsimilador);
		this.construccionesCreables.add(nombreNexoMineral);
		this.construccionesCreables.add(nombrePuertoEstelar);
		this.construccionesCreables.add(nombrePilon);
		
	}

	@Override
	public Construccion crearConstruccion(EnumEdificios nombreEdificio) {
		if(nombreEdificio==nombreAcceso)
			return this.crearConstruccionEspecifico(nombreAcceso, recursosNecesariosAcceso);
		if(nombreEdificio==nombreBaseProtos)
			return this.crearConstruccionEspecifico(nombreBaseProtos, recursosNecesariosBaseProtos);
		if(nombreEdificio==nombreArchivosTemplarios && this.duenio.tieneConstruccion(nombrePuertoEstelar))
			return this.crearConstruccionEspecifico(nombreArchivosTemplarios, recursosNecesariosArchivosTemplarios);
		if(nombreEdificio==nombreAsimilador)
			return this.crearConstruccionEspecifico(nombreAsimilador, recursosNecesariosAsimilador);
		if(nombreEdificio==nombreNexoMineral)
			return this.crearConstruccionEspecifico(nombreNexoMineral, recursosNecesariosNexoMineral);
		if(nombreEdificio==nombrePuertoEstelar && this.duenio.tieneConstruccion(nombreAcceso))
			return this.crearConstruccionEspecifico(nombrePuertoEstelar, recursosNecesariosPuertoEstelar);
		if(nombreEdificio==nombrePilon)
			return this.crearConstruccionEspecifico(nombrePilon, recursosNecesariosPilon);
		return null;
	}

}

