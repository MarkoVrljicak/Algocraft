package algocraft.unidades.Alternativas.protos;

import stats.Escudo;
import stats.Movimientos;
import stats.Stat;
import stats.Vida;
import algocraft.unidades.Alternativas.Unidad;



public class AltoTemplario extends Unidad {
	
	public AltoTemplario(){
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.ALTO_TEMPLARIO;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(40);
		this.stat = new Escudo(40, vida);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(3);
	}
	
	@Override
	public int getVida() {
		return ((Escudo)this.stat).actualProtegida();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 7;
	}	
	
}
