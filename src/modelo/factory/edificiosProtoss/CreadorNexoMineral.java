package modelo.factory.edificiosProtoss;

import modelo.construcciones.EdificioConEscudo;
import modelo.construcciones.EnumEdificios;
import modelo.construcciones.RecolectorMineral;
import modelo.factory.EdificiosAbstractFactory;
import modelo.stats.Recurso;

public class CreadorNexoMineral extends EdificiosAbstractFactory {

	private int escudo;

	public CreadorNexoMineral(){
		this.recursosNecesarios = new Recurso(50,0);
		this.vida = 250;
		this.tiempoDeConstruccion = 4;
		this.escudo = 250;
	}
	
	@Override
	public RecolectorMineral crearEdificio() {
		return new RecolectorMineral(new EdificioConEscudo(EnumEdificiosProtos.NEXO_MINERAL,vida,tiempoDeConstruccion,escudo));
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
