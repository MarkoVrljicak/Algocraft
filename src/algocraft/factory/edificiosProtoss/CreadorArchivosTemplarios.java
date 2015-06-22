package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.factory.unidadesProtoss.CreadorAltoTemplario;
import algocraft.stats.Recurso;
import algocraft.unidades.protos.UnidadesProtos;

public class CreadorArchivosTemplarios extends EdificiosAbstractFactory {

	private EnumEdificiosProtos construccionNecesitada;
	private int escudo;

	public CreadorArchivosTemplarios(){
		this.recursosNecesarios = new Recurso(150,200);
		this.construccionNecesitada = EnumEdificiosProtos.PUERTO_ESTELAR;
		this.vida = 500;
		this.tiempoDeConstruccion = 9;
		this.escudo = 500;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades archivos = new CreadorDeUnidades(new EdificioConEscudo(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS,vida,tiempoDeConstruccion,escudo));
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
