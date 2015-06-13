package algocraft.razas;

import algocraft.factory.edificiosTerran.*;

public class Terran extends Raza{
		
	public Terran(){
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
