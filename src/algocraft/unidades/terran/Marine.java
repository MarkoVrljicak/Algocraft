package algocraft.unidades.terran;

import algocraft.ataques.Danio;
import algocraft.stats.Movimientos;
import algocraft.stats.Vida;
import algocraft.unidades.Unidad;



public class Marine extends Unidad{

	public Marine() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.MARINE;
	}

	@Override
	protected void setearVida() {
		this.stat = new Vida(40);
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
		return this.stat.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 3;
	}	
}
