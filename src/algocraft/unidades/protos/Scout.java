package algocraft.unidades.protos;


import algocraft.ataques.Danio;
import algocraft.movimientos.MovimientoAereo;
import algocraft.stats.Escudo;
import algocraft.stats.Movimientos;
import algocraft.stats.Stat;
import algocraft.stats.Vida;
import algocraft.unidades.UnidadAtacante;

public class Scout extends UnidadAtacante {

	public Scout() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.SCOUT;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(150);
		this.vitalidad = new Escudo(100, vida);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;		
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 3;
	}

	@Override
	protected void setearDanio() {
		int danioAereo = 14;
		int danioTerrestre = 8;
		int rango = 4;
		this.danio = new Danio(danioAereo, danioTerrestre, rango, rango);
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(3);
	}	
	
	@Override
	public int getVida() {
		return ((Escudo)this.vitalidad).actualProtegida();
	}	
	
	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 9;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoAereo();
		
	}	
}
