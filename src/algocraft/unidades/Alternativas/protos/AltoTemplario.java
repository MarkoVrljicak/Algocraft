package algocraft.unidades.Alternativas.protos;

import algocraft.unidades.Alternativas.Unidad;



public class AltoTemplario extends Unidad {
	
	public AltoTemplario(){
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.ALTO_TEMPLARIO;
	}

	@Override
	protected void setearVida() {
		this.vida.set(40);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 2;
		
	}

	@Override
	protected void setearAtaque() {
		// TODO Auto-generated method stub
		
	}

	

	
}
