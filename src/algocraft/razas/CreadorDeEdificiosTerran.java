package algocraft.razas;

import algocraft.factory.edificiosTerran.CreadorBarraca;
import algocraft.factory.edificiosTerran.CreadorBaseTerran;
import algocraft.factory.edificiosTerran.CreadorCentroDeMineral;
import algocraft.factory.edificiosTerran.CreadorDepositoDeSuministros;
import algocraft.factory.edificiosTerran.CreadorFabrica;
import algocraft.factory.edificiosTerran.CreadorPuertoEstelar;
import algocraft.factory.edificiosTerran.CreadorRefineria;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;

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
