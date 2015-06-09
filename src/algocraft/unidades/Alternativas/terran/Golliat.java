package algocraft.unidades.Alternativas.terran;


import stats.Movimientos;
import algocraft.ataques.Danio;
import algocraft.unidades.Alternativas.Unidad;

public class Golliat extends Unidad{

	public Golliat() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.GOLLIAT;
	}

	@Override
	protected void setearVida() {
		this.vida.set(125);
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
		int danioAereo = 10;
		int danioTerrestre = 12;
		int rangoAereo = 5;
		int rangoTerrestre = 6;
		
		this.danio = new Danio(danioAereo, danioTerrestre, rangoAereo, rangoTerrestre);
		
	}
	
	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos();
		this.movimientos.set(4);
	}

}

