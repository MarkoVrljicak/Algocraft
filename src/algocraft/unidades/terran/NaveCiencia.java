package algocraft.unidades.terran;

import algocraft.stats.Movimientos;
import algocraft.stats.Vida;
import algocraft.unidades.Unidad;



public class NaveCiencia extends Unidad{

	public NaveCiencia() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.NAVE_CIENCIA;
	}

	@Override
	protected void setearVida() {
		this.vitalidad = new Vida(200);
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
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(5);
	}

	@Override
	public int getVida() {
		return vitalidad.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 10;
	}	
}
