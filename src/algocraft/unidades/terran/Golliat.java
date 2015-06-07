package algocraft.unidades.terran;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class Golliat extends Unidad{

	public Golliat() {
		nombre = "Golliat";
		this.vida.set(125);
	}
	
	public Creable clonar(){
		return new Golliat();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}
}
