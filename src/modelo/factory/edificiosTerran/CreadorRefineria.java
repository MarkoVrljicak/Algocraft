package modelo.factory.edificiosTerran;

import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EnumEdificios;
import modelo.construcciones.RecolectorGas;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

public class CreadorRefineria extends EdificiosAbstractFactory {

	public CreadorRefineria(){
		this.recursosNecesarios = new Recurso(100,0);
		this.vida = 750;
		this.tiempoDeConstruccion = 6;
	}
	
	@Override
	public RecolectorGas crearEdificio() {
		return new RecolectorGas(new EdificioBasico(EnumEdificiosTerran.REFINERIA,vida,tiempoDeConstruccion));
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
