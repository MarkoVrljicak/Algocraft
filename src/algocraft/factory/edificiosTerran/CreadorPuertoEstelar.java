package algocraft.factory.edificiosTerran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.factory.unidadesTerran.CreadorEspectro;
import algocraft.factory.unidadesTerran.CreadorNaveCiencia;
import algocraft.factory.unidadesTerran.CreadorNaveTransporte;
import algocraft.stats.Recurso;
import algocraft.unidades.terran.UnidadesTerran;

public class CreadorPuertoEstelar extends EdificiosAbstractFactory {

	private EnumEdificiosTerran construccionNecesitada;

	public CreadorPuertoEstelar(){
		this.recursosNecesarios = new Recurso(150,100);
		this.construccionNecesitada = EnumEdificiosTerran.FABRICA;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades puertoEstelar = new CreadorDeUnidades(new EdificioBasico(EnumEdificiosTerran.PUERTO_ESTELAR,1300,10));
		puertoEstelar.aniadirUnidadCreable(UnidadesTerran.ESPECTRO, new CreadorEspectro());
		puertoEstelar.aniadirUnidadCreable(UnidadesTerran.NAVE_TRANSPORTE, new CreadorNaveTransporte());
		puertoEstelar.aniadirUnidadCreable(UnidadesTerran.NAVE_CIENCIA, new CreadorNaveCiencia());
		return puertoEstelar;
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}

	public EnumEdificiosTerran getConstruccionNecesitada(){
		return construccionNecesitada;
	}
}
