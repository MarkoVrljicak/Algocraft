package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class AltoTemplario extends Unidad {

	public AltoTemplario(){
		this.nombre="Alto Templario";
		this.vida.set(40);
	}
	
	@Override
	public Creable clonar() {
		
		return new AltoTemplario();
	}

	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		// TODO Auto-generated method stub
		return false;
	}

}
