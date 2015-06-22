package algocraft.factory.edificiosTerran;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.factory.unidadesTerran.CreadorMarine;
import algocraft.stats.Recurso;
import algocraft.unidades.terran.UnidadesTerran;

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
