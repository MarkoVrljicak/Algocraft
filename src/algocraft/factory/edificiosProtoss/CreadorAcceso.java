package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.factory.unidadesProtoss.CreadorDragon;
import algocraft.factory.unidadesProtoss.CreadorZealot;
import algocraft.stats.Recurso;
import algocraft.unidades.protos.UnidadesProtos;

public class CreadorAcceso extends EdificiosAbstractFactory {

	private int escudo;

	public CreadorAcceso(){
		this.recursosNecesarios = new Recurso(150,0);
		this.vida = 500;
		this.tiempoDeConstruccion = 8;
		this.escudo = 500;
	}
	
	@Override
	public CreadorDeUnidades crearEdificio() {
		CreadorDeUnidades acceso = new CreadorDeUnidades(new EdificioConEscudo(EnumEdificiosProtos.ACCESO,vida,tiempoDeConstruccion,escudo));
		acceso.aniadirUnidadCreable(UnidadesProtos.ZEALOT, new CreadorZealot());
		acceso.aniadirUnidadCreable(UnidadesProtos.DRAGON, new CreadorDragon());
		return acceso;
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
