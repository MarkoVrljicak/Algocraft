package modelo.factory.edificiosTerran;

import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EdificioBasico;
import modelo.factory.EdificiosAbstractFactory;
import modelo.factory.unidadesTerran.CreadorGolliat;
import modelo.stats.Recurso;
import modelo.unidades.terran.UnidadesTerran;

public class CreadorFabrica extends EdificiosAbstractFactory {

	private EnumEdificiosTerran construccionNecesitada;

	public CreadorFabrica(){
		this.recursosNecesarios = new Recurso(200,100);
		this.construccionNecesitada = EnumEdificiosTerran.BARRACA;
		this.vida = 1250;
		this.tiempoDeConstruccion = 12;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades fabrica =  new CreadorDeUnidades(new EdificioBasico(EnumEdificiosTerran.FABRICA,vida,tiempoDeConstruccion));
		fabrica.aniadirUnidadCreable(UnidadesTerran.GOLLIAT, new CreadorGolliat());
		return fabrica;
	}

	@Override
	public boolean necesitoConstruccionAnterior() {
		return true;
	}

	public EnumEdificiosTerran getConstruccionNecesitada(){
		return construccionNecesitada;
	}
}
