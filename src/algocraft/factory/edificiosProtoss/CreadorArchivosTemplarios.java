package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.ArchivosTemplarios;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.factory.CreadorDeEdificios;
import algocraft.stats.Recurso;

public class CreadorArchivosTemplarios extends CreadorDeEdificios {

	private EnumEdificiosProtos construccionNecesitada;

	public CreadorArchivosTemplarios(){
		this.recursosNecesarios = new Recurso(150,200);
		this.construccionNecesitada = EnumEdificiosProtos.PUERTO_ESTELAR;
	}
	
	@Override
	public Construccion crearEdificio() {
		return new ArchivosTemplarios();
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}
	
	public EnumEdificiosProtos getConstruccionNecesitada(){
		return construccionNecesitada;
	}

}
