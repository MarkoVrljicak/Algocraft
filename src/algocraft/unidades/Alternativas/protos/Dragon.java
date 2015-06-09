package algocraft.unidades.Alternativas.protos;


import stats.Escudo;
import stats.Movimientos;
import stats.Stat;
import stats.Vida;
import algocraft.ataques.Danio;
import algocraft.unidades.Alternativas.Unidad;

public class Dragon extends Unidad {
	
	public Dragon(){
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.DRAGON;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(100);
		this.stat = new Escudo(80, vida);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 4;
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 2;
	}

	@Override
	protected void setearDanio() {
		int danio = 20;
		int rango = 4;
		this.danio = new Danio(danio, danio, rango, rango);
		
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
