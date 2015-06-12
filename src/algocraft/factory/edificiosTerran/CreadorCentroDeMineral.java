package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.terran.CentroDeMineral;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorCentroDeMineral extends CreadorDeEdificios {

	public CreadorCentroDeMineral(){
		this.recursosNecesarios = new Recurso(50,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new CentroDeMineral();
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
