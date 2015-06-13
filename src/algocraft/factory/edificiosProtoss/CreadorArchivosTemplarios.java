package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.factory.unidadesProtoss.CreadorAltoTemplario;
import algocraft.stats.Recurso;
import algocraft.unidades.protos.UnidadesProtos;

public class CreadorArchivosTemplarios extends EdificiosAbstractFactory {

	private EnumEdificiosProtos construccionNecesitada;

	public CreadorArchivosTemplarios(){
		this.recursosNecesarios = new Recurso(150,200);
		this.construccionNecesitada = EnumEdificiosProtos.PUERTO_ESTELAR;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades archivos = new CreadorDeUnidades(new EdificioConEscudo(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS,500,9,500));
		archivos.aniadirUnidadCreable(UnidadesProtos.ALTO_TEMPLARIO, new CreadorAltoTemplario());
		return archivos;
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}
	
	public EnumEdificiosProtos getConstruccionNecesitada(){
		return construccionNecesitada;
	}

}
