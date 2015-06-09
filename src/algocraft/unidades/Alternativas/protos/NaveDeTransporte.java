package algocraft.unidades.Alternativas.protos;

import stats.Movimientos;
import algocraft.unidades.Alternativas.Unidad;


public class NaveDeTransporte extends Unidad {

	public NaveDeTransporte() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.NAVE_DE_TRANSPORTE;
	}

	@Override
	protected void setearVida() {
		this.vida.set(150);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;
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
		this.movimientos.set(4);
	}	
}
