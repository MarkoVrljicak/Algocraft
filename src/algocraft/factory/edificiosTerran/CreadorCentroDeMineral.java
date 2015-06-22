package algocraft.factory.edificiosTerran;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.RecolectorMineral;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

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
