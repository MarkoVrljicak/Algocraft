package algocraft.unidades.Alternativas.protos;

import stats.Escudo;
import stats.Movimientos;
import stats.Stat;
import stats.Vida;
import algocraft.unidades.Alternativas.Unidad;


public class NaveDeTransporte extends Unidad {

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
		this.stat = new Escudo(60, vida);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(4);
	}

	@Override
	public int getVida() {
		return ((Escudo)this.stat).actualProtegida();
	}	
}
