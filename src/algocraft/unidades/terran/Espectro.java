package algocraft.unidades.terran;

import algocraft.ataques.AtaqueNormal;
import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class Espectro extends Unidad{

	public Espectro() {
		nombre = "Espectro";
		this.vida.set(120);
		this.ataque = new AtaqueNormal(20, 8, 5);
	}
	
	public Creable clonar(){
		return new Espectro();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}
}
