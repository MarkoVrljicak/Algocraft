package modelo.factory.edificiosProtoss;

import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EdificioConEscudo;
import modelo.factory.EdificiosAbstractFactory;
import modelo.factory.unidadesProtoss.CreadorNaveDeTransporte;
import modelo.factory.unidadesProtoss.CreadorScout;
import modelo.stats.Recurso;
import modelo.unidades.protos.UnidadesProtos;

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
