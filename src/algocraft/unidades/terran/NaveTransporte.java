package algocraft.unidades.terran;

import algocraft.stats.Movimientos;
import algocraft.stats.Vida;
import algocraft.unidades.UnidadTransportadora;

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
		this.vitalidad = new Vida(150);
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
		return this.vitalidad.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 7;
	}	
}
