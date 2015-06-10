package algocraft.unidades.Alternativas.terran;

import stats.Movimientos;
import stats.Vida;
import algocraft.unidades.Alternativas.UnidadTransportadora;

public class NaveTransporte extends UnidadTransportadora{

	public NaveTransporte() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.NAVE_TRANSPORTE;
	}

	@Override
	protected void setearVida() {
		this.stat = new Vida(150);
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 2;
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(4);
	}

	@Override
	public int getVida() {
		return this.stat.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 7;
	}	
}
