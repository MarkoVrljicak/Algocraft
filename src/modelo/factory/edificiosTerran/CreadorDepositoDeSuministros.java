package modelo.factory.edificiosTerran;

import modelo.construcciones.Construccion;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EnumEdificios;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

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
