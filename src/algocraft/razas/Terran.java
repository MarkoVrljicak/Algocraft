package algocraft.razas;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.terran.EnumEdificiosTerran;
import algocraft.stats.Recurso;

public class Terran extends Raza{

	
	private static final Recurso recursosNecesariosBarraca = new Recurso(150,0);
	private static final Recurso recursosNecesariosBaseTerran = new Recurso(0,0);
	private static final Recurso recursosNecesariosCentroDeMineral = new Recurso(50,0);
	private static final Recurso recursosNecesariosDepositoDeSuministros = new Recurso(100,0);
	private static final Recurso recursosNecesariosFabrica = new Recurso(200,100);
	private static final Recurso recursosNecesariosPuertoEstelar = new Recurso(150,100);
	private static final Recurso recursosNecesariosRefineria = new Recurso(100,0);
	
	public Terran(){
		this.nombre = EnumRazas.TERRAN;
	}
	
	@Override
	protected void determinarCreables() {
		this.construccionesCreables.add(EnumEdificiosTerran.BARRACA);
		this.construccionesCreables.add(EnumEdificiosTerran.BASE_TERRAN);
		this.construccionesCreables.add(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		this.construccionesCreables.add(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS);
		this.construccionesCreables.add(EnumEdificiosTerran.FABRICA);
		this.construccionesCreables.add(EnumEdificiosTerran.PUERTO_ESTELAR);
		this.construccionesCreables.add(EnumEdificiosTerran.REFINERIA);
		
	}

	@Override
	public Construccion crearConstruccion(EnumEdificios nombreEdificio) {
		if(nombreEdificio==EnumEdificiosTerran.BARRACA)
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.BARRACA, recursosNecesariosBarraca);
		
		if(nombreEdificio==EnumEdificiosTerran.BASE_TERRAN)
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.BASE_TERRAN, recursosNecesariosBaseTerran);
		
		if(nombreEdificio==EnumEdificiosTerran.CENTRO_DE_MINERALES)
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.CENTRO_DE_MINERALES, recursosNecesariosCentroDeMineral);
		
		if(nombreEdificio==EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS)
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS,
					recursosNecesariosDepositoDeSuministros);
		
		if(nombreEdificio==EnumEdificiosTerran.FABRICA 
				&& this.duenio.tieneConstruccion(EnumEdificiosTerran.BARRACA))
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.FABRICA, recursosNecesariosFabrica);
		
		if(nombreEdificio==EnumEdificiosTerran.PUERTO_ESTELAR
				&& this.duenio.tieneConstruccion(EnumEdificiosTerran.FABRICA))
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.PUERTO_ESTELAR, recursosNecesariosPuertoEstelar);
		
		if(nombreEdificio==EnumEdificiosTerran.REFINERIA)
			return this.crearConstruccionEspecifico(EnumEdificiosTerran.REFINERIA, recursosNecesariosRefineria);
		
		return null;
	}

}
