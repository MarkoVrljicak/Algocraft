package algocraft.factory.edificiosTerran;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.terran.DepositoDeSuministros;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorDepositoDeSuministros extends CreadorDeEdificios {

	public CreadorDepositoDeSuministros(){
		this.recursosNecesarios = new Recurso(100,0);
	}
	
	@Override
	public Construccion crearEdificio() {
		return new DepositoDeSuministros();
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
