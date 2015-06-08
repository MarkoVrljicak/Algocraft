package algocraft.unidades.terran;

import algocraft.ataques.AtaqueNormal;
import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class Marine extends Unidad{

	public Marine() {
		nombre = "Marine";
		this.vida.set(40);
		this.ataque = new AtaqueNormal(4, 6, 6);
	}
	
	public Creable clonar(){
		return new Marine();
	}
	
	public boolean puedoMoverme(int distancia, Terreno terrenoDestino){
		return false;
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		return terrenoDestino.sePuedeCaminar();
	}

}
