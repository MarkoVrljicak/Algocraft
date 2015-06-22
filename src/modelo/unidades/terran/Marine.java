package modelo.unidades.terran;

import modelo.ataques.Danio;
import modelo.movimientos.MovimientoTerrestre;
import modelo.stats.Movimientos;
import modelo.stats.Vida;
import modelo.unidades.UnidadAtacante;



public class Marine extends UnidadAtacante{

	public Marine() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.MARINE;
	}

	@Override
	protected void setearVida() {
		this.vitalidad = new Vida(40);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 1;
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 1;
	}

	@Override
	protected void setearDanio() {
		int danio = 6;
		int rango = 4;
		this.danio = new Danio(danio, danio, rango, rango);
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(3);
	}

	@Override
	public int getVida() {
		return this.vitalidad.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 3;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoTerrestre();
		
	}	
}
