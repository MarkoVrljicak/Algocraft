package modelo.unidades.protos;

import modelo.movimientos.MovimientoAereo;
import modelo.stats.Escudo;
import modelo.stats.Movimientos;
import modelo.stats.Stat;
import modelo.stats.Vida;
import modelo.unidades.UnidadTransportadora;


public class NaveDeTransporte extends UnidadTransportadora {

	public NaveDeTransporte() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.NAVE_DE_TRANSPORTE;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(80);
		this.vitalidad = new Escudo(60, vida);
	}

	@Override
	protected void setearSuministros() {
		this.suministros = 2;
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(4);
	}

	@Override
	public int getVida() {
		return ((Escudo)this.vitalidad).actualProtegida();
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
