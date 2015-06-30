package modelo.unidades.terran;

import modelo.ataques.Danio;
import modelo.movimientos.MovimientoAereo;
import modelo.stats.Movimientos;
import modelo.stats.Vida;
import modelo.unidades.UnidadAtacante;


public class Espectro extends UnidadAtacante{

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
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 8;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoAereo();
		
	}

}
