package modelo.razas;

import modelo.factory.edificiosTerran.CreadorBarraca;
import modelo.factory.edificiosTerran.CreadorBaseTerran;
import modelo.factory.edificiosTerran.CreadorCentroDeMineral;
import modelo.factory.edificiosTerran.CreadorDepositoDeSuministros;
import modelo.factory.edificiosTerran.CreadorFabrica;
import modelo.factory.edificiosTerran.CreadorPuertoEstelar;
import modelo.factory.edificiosTerran.CreadorRefineria;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;

public class CreadorDeEdificiosTerran extends CreadorDeEdificios{
		
	public CreadorDeEdificiosTerran(){
		super();
		this.nombre = EnumRazas.TERRAN;
	}
	
	@Override
	protected void determinarCreables() {
		this.aniadirEdificioCreable(EnumEdificiosTerran.BARRACA, new CreadorBarraca());
		this.aniadirEdificioCreable(EnumEdificiosTerran.BASE_TERRAN, new CreadorBaseTerran());
		this.aniadirEdificioCreable(EnumEdificiosTerran.CENTRO_DE_MINERALES, new CreadorCentroDeMineral());
		this.aniadirEdificioCreable(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, new CreadorDepositoDeSuministros());
		this.aniadirEdificioCreable(EnumEdificiosTerran.FABRICA, new CreadorFabrica());
		this.aniadirEdificioCreable(EnumEdificiosTerran.PUERTO_ESTELAR, new CreadorPuertoEstelar());
		this.aniadirEdificioCreable(EnumEdificiosTerran.REFINERIA, new CreadorRefineria());
		
	}

}
