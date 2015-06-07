package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class NaveDeTransporte extends Unidad {

	public NaveDeTransporte() {
		nombre = "Nave de Transporte";
		this.vida.set(80);
	}
	
	public Creable clonar(){
		return new NaveDeTransporte();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}
}
