package modelo.factory.edificiosTerran;

import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EnumEdificios;
import modelo.factory.EdificiosAbstractFactory;
import modelo.factory.unidadesTerran.CreadorMarine;
import modelo.stats.Recurso;
import modelo.unidades.terran.UnidadesTerran;

public class CreadorBarraca extends EdificiosAbstractFactory {

	public CreadorBarraca(){
		this.recursosNecesarios = new Recurso(150,0);
		this.vida = 1000;
		this.tiempoDeConstruccion = 12;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades barraca = new CreadorDeUnidades(new EdificioBasico(EnumEdificiosTerran.BARRACA,vida,tiempoDeConstruccion));
		barraca.aniadirUnidadCreable(UnidadesTerran.MARINE, new CreadorMarine());
		return barraca;
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
