package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class Dragon extends Unidad {
	
	public Dragon(){
		nombre="Dragon";
		this.vida.set(100);
	}
	
	
	@Override
	public Creable clonar() {
		
		return new Dragon();
	}


	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}

}
