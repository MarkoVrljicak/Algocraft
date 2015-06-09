package algocraft.unidades.Alternativas.terran;

import algocraft.ataques.Danio;
import algocraft.unidades.Alternativas.Unidad;



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
		this.vida.set(40);
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



}
