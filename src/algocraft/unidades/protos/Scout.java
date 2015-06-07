package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class Scout extends Unidad {

	public Scout() {
		nombre = "Scout";
		this.vida.set(150);
	}
	
	public Creable clonar(){
		return new Scout();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}
}
