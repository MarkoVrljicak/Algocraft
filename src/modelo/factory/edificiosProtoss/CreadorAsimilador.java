package modelo.factory.edificiosProtoss;

import modelo.construcciones.EdificioConEscudo;
import modelo.construcciones.EnumEdificios;
import modelo.construcciones.RecolectorGas;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

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
