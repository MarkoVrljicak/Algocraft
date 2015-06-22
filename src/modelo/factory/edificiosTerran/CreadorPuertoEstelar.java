package modelo.factory.edificiosTerran;

import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EdificioBasico;
import modelo.factory.EdificiosAbstractFactory;
import modelo.factory.unidadesTerran.CreadorEspectro;
import modelo.factory.unidadesTerran.CreadorNaveCiencia;
import modelo.factory.unidadesTerran.CreadorNaveTransporte;
import modelo.stats.Recurso;
import modelo.unidades.terran.UnidadesTerran;

public class CreadorPuertoEstelar extends EdificiosAbstractFactory {

	private EnumEdificiosTerran construccionNecesitada;

	public CreadorPuertoEstelar(){
		this.recursosNecesarios = new Recurso(150,100);
		this.construccionNecesitada = EnumEdificiosTerran.FABRICA;
		this.vida = 1300;
		this.tiempoDeConstruccion = 10;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades puertoEstelar = new CreadorDeUnidades(new EdificioBasico(EnumEdificiosTerran.PUERTO_ESTELAR,vida,tiempoDeConstruccion));
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
