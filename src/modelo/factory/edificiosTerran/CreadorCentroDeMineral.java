package modelo.factory.edificiosTerran;

import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EnumEdificios;
import modelo.construcciones.RecolectorMineral;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

public class CreadorCentroDeMineral extends EdificiosAbstractFactory {
	
	public CreadorCentroDeMineral(){
		this.recursosNecesarios = new Recurso(50,0);
		this.vida = 500;
		this.tiempoDeConstruccion = 4;
	}
	
	@Override
	public RecolectorMineral crearEdificio() {
		return new RecolectorMineral(new EdificioBasico(EnumEdificiosTerran.CENTRO_DE_MINERALES,vida,tiempoDeConstruccion));
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
