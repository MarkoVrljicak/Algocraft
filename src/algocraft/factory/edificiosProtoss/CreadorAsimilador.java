package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.RecolectorGas;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorAsimilador extends EdificiosAbstractFactory {

	private int escudo;

	public CreadorAsimilador(){
		this.recursosNecesarios = new Recurso(100,0);
		this.vida = 450;
		this.tiempoDeConstruccion = 6;
		this.escudo = 450;
	}
	
	@Override
	public RecolectorGas crearEdificio() {
		return new RecolectorGas(new EdificioConEscudo(EnumEdificiosProtos.ASIMILADOR,vida,tiempoDeConstruccion,escudo));
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
