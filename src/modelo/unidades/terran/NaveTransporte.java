package modelo.unidades.terran;

import modelo.movimientos.MovimientoAereo;
import modelo.stats.Movimientos;
import modelo.stats.Vida;
import modelo.unidades.UnidadTransportadora;

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
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 7;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoAereo();
		
	}	
}
