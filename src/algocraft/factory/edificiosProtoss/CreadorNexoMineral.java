package algocraft.factory.edificiosProtoss;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.EnumEdificios;
import algocraft.construcciones.RecolectorMineral;
import algocraft.factory.EdificiosAbstractFactory;
import algocraft.stats.Recurso;

public class CreadorNexoMineral extends EdificiosAbstractFactory {

	public CreadorNexoMineral(){
		this.recursosNecesarios = new Recurso(50,0);
	}
	
	@Override
	public RecolectorMineral crearEdificio() {
		return new RecolectorMineral(new EdificioConEscudo(EnumEdificiosProtos.NEXO_MINERAL,250,4,250));
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
