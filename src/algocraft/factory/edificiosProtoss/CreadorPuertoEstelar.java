package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.construcciones.protos.PuertoEstelar;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorPuertoEstelar extends CreadorDeEdificios {

	private EnumEdificiosProtos construccionNecesitada;

	public CreadorPuertoEstelar(){
		this.recursosNecesarios = new Recurso(150,100);
		this.construccionNecesitada = EnumEdificiosProtos.ACCESO;
	}
	
	@Override
	public Construccion crearEdificio() {
		return new PuertoEstelar();
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}

	public EnumEdificiosProtos getConstruccionNecesitada(){
		return construccionNecesitada;
	}
}
