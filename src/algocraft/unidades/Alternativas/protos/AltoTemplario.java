package algocraft.unidades.Alternativas.protos;

import stats.Movimientos;
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
	protected void setearSuministros() {
		this.suministros = 2;
	}


	@Override
	protected void setearDanio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos();
		this.movimientos.set(3);
	}

	



	

	
}
