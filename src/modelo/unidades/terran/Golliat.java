package modelo.unidades.terran;


import modelo.ataques.Danio;
import modelo.movimientos.MovimientoTerrestre;
import modelo.stats.Movimientos;
import modelo.stats.Vida;
import modelo.unidades.UnidadAtacante;

public class Golliat extends UnidadAtacante{

	public Golliat() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.GOLLIAT;
	}

	@Override
	protected void setearVida() {
		this.vitalidad = new Vida(125);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 2;
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 2;
	}

	@Override
	protected void setearDanio() {
		int danioAereo = 10;
		int danioTerrestre = 12;
		int rangoAereo = 5;
		int rangoTerrestre = 6;
		
		this.danio = new Danio(danioAereo, danioTerrestre, rangoAereo, rangoTerrestre);
		
	}
	
	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(4);
	}

	@Override
	public int getVida() {
		return vitalidad.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 6;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoTerrestre();
		
	}	
}

