package algocraft.unidades.Alternativas.protos;


import stats.Movimientos;
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
		this.vida.set(100);
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
		this.movimientos = new Movimientos();
		this.movimientos.set(3);
	}
}
