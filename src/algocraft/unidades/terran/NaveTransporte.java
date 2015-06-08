package algocraft.unidades.terran;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class NaveTransporte extends Unidad{

	public NaveTransporte() {
		nombre = "Nave Transporte";
		this.vida.set(150);
	}
	
	public Creable clonar(){
		return new NaveTransporte();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object soyVolador() {
		// TODO Auto-generated method stub
		return null;
	}
}
