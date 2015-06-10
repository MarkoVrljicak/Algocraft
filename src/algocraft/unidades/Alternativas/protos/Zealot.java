package algocraft.unidades.Alternativas.protos;


import stats.Escudo;
import stats.Movimientos;
import stats.Stat;
import stats.Vida;
import algocraft.ataques.Danio;
import algocraft.unidades.Alternativas.Unidad;

public class Zealot extends Unidad{

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
		this.stat = new Escudo(60, vida);
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
		return ((Escudo)this.stat).actualProtegida();
	}	
	
	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 4;
	}	
}
