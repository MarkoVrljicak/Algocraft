package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.factory.unidadesProtoss.CreadorNaveDeTransporte;
import algocraft.factory.unidadesProtoss.CreadorScout;
import algocraft.stats.Recurso;
import algocraft.unidades.protos.UnidadesProtos;

public class CreadorPuertoEstelar extends EdificiosAbstractFactory {

	private EnumEdificiosProtos construccionNecesitada;
	private int escudo;

	public CreadorPuertoEstelar(){
		this.recursosNecesarios = new Recurso(150,100);
		this.construccionNecesitada = EnumEdificiosProtos.ACCESO;
		this.vida = 600;
		this.tiempoDeConstruccion = 10;
		this.escudo = 600;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades puerto = new CreadorDeUnidades((new EdificioConEscudo(EnumEdificiosProtos.PUERTO_ESTELAR,vida,tiempoDeConstruccion,escudo)));
		puerto.aniadirUnidadCreable(UnidadesProtos.SCOUT, new CreadorScout());
		puerto.aniadirUnidadCreable(UnidadesProtos.NAVE_DE_TRANSPORTE, new CreadorNaveDeTransporte());
		return puerto;
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}

	public EnumEdificiosProtos getConstruccionNecesitada(){
		return construccionNecesitada;
	}
}
