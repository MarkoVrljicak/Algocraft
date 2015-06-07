package algocraft.unidades.terran;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class NaveCiencia extends Unidad{

	public NaveCiencia() {
		nombre = "Nave Ciencia";
		this.vida.set(200);
	}
	
	public Creable clonar(){
		return new NaveCiencia();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}
}
