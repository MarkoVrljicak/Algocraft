package algocraft.unidades;

import algocraft.creables.Creable;

public class AltoTemplario extends Unidad {

	public AltoTemplario(){
		this.nombre="Alto Templario";
		this.vida.set(40);
	}
	
	@Override
	public Creable clonar() {
		
		return new AltoTemplario();
	}

}
