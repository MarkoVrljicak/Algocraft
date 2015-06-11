package algocraft.unidades.protos;

import algocraft.stats.Escudo;
import algocraft.stats.Movimientos;
import algocraft.stats.Stat;
import algocraft.stats.Vida;
import algocraft.unidades.UnidadTransportadora;


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
}
