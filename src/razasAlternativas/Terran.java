package razasAlternativas;

import stats.Recurso;
import Interfaces.Construccion;
import algocraft.construccionesAlternativas.EnumEdificios;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;

public class Terran extends Raza{

	private static final EnumEdificiosTerran nombreBarraca= EnumEdificiosTerran.BARRACA;
	private static final EnumEdificiosTerran nombreBaseTerran= EnumEdificiosTerran.BASE_TERRAN;
	private static final EnumEdificiosTerran nombreCentroDeMineral= EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreDepositoDeSuministros= EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS;
	private static final EnumEdificiosTerran nombreFabrica= EnumEdificiosTerran.FABRICA;
	private static final EnumEdificiosTerran nombrePuertoEstelar= EnumEdificiosTerran.PUERTO_ESTELAR;
	private static final EnumEdificiosTerran nombreRefineria= EnumEdificiosTerran.REFINERIA;
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
		this.construccionesCreables.add(nombreBarraca);
		this.construccionesCreables.add(nombreBaseTerran);
		this.construccionesCreables.add(nombreCentroDeMineral);
		this.construccionesCreables.add(nombreDepositoDeSuministros);
		this.construccionesCreables.add(nombreFabrica);
		this.construccionesCreables.add(nombrePuertoEstelar);
		this.construccionesCreables.add(nombreRefineria);
		
	}

	@Override
	public Construccion crearConstruccion(EnumEdificios nombreEdificio) {
		if(nombreEdificio==nombreBarraca)
			return this.crearConstruccionEspecifico(nombreBarraca, recursosNecesariosBarraca);
		if(nombreEdificio==nombreBaseTerran)
			return this.crearConstruccionEspecifico(nombreBaseTerran, recursosNecesariosBaseTerran);
		if(nombreEdificio==nombreCentroDeMineral)
			return this.crearConstruccionEspecifico(nombreCentroDeMineral, recursosNecesariosCentroDeMineral);
		if(nombreEdificio==nombreDepositoDeSuministros)
			return this.crearConstruccionEspecifico(nombreDepositoDeSuministros, recursosNecesariosDepositoDeSuministros);
		if(nombreEdificio==nombreFabrica && this.duenio.tieneConstruccion(nombreBarraca))
			return this.crearConstruccionEspecifico(nombreFabrica, recursosNecesariosFabrica);
		if(nombreEdificio==nombrePuertoEstelar && this.duenio.tieneConstruccion(nombreFabrica))
			return this.crearConstruccionEspecifico(nombrePuertoEstelar, recursosNecesariosPuertoEstelar);
		if(nombreEdificio==nombreRefineria)
			return this.crearConstruccionEspecifico(nombreRefineria, recursosNecesariosRefineria);
		return null;
	}

}
