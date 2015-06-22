package modelo.unidades.protos;


import modelo.ataques.Danio;
import modelo.movimientos.MovimientoTerrestre;
import modelo.stats.Escudo;
import modelo.stats.Movimientos;
import modelo.stats.Stat;
import modelo.stats.Vida;
import modelo.unidades.UnidadAtacante;

public class Zealot extends UnidadAtacante{

	public Zealot() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.ZEALOT;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(100);
		this.vitalidad = new Escudo(60, vida);
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
		int danioAereo = 0;
		int danioTerrestre = 8;
		int rango = 1;
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
		this.tiempoDeConstruccion = 4;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoTerrestre();
		
	}	
}
