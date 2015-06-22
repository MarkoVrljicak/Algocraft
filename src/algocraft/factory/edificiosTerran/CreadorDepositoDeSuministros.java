package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorDepositoDeSuministros extends EdificiosAbstractFactory {

	public CreadorDepositoDeSuministros(){
		this.recursosNecesarios = new Recurso(100,0);
		this.vida = 500;
		this.tiempoDeConstruccion = 6;
	}
	
	@Override
	public Construccion crearEdificio() {
		EdificioBasico deposito = new EdificioBasico(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS,vida,tiempoDeConstruccion);
		deposito.setPoblacionSumada(5);
		return deposito;
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return false;
	}

	@Override
	public EnumEdificios getConstruccionNecesitada() {
		return null;
	}

}
