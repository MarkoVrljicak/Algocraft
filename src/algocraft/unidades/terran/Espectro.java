package algocraft.unidades.terran;

import algocraft.ataques.Danio;
import algocraft.movimientos.MovimientoAereo;
import algocraft.stats.Movimientos;
import algocraft.stats.Vida;
import algocraft.unidades.Unidad;


public class Espectro extends Unidad{

	public Espectro() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.ESPECTRO;
	}

	@Override
	protected void setearVida() {
		this.vitalidad = new Vida(120);
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
		int danioAereo = 20;
		int danioTerrestre = 8;
		int rango = 5;
		this.danio = new Danio(danioAereo, danioTerrestre, rango, rango);
		
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
		this.tiempoDeConstruccion = 8;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoAereo();
		
	}	
}
