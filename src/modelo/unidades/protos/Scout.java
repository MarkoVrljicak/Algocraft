package modelo.unidades.protos;


import modelo.ataques.Danio;
import modelo.movimientos.MovimientoAereo;
import modelo.stats.Escudo;
import modelo.stats.Movimientos;
import modelo.stats.Stat;
import modelo.stats.Vida;
import modelo.unidades.UnidadAtacante;

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
	public int getVidaMaxima() {
		return ((Escudo)this.vitalidad).maxProtegida();
	}

	@Override
	public int getEscudo() {
		return ((Escudo)this.vitalidad).actual();
	}

	@Override
	public int getEscudoMaximo() {
		return ((Escudo)this.vitalidad).max();
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
