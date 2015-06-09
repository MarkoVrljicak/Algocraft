package algocraft.unidades.Alternativas.protos;


import algocraft.ataques.Danio;
import algocraft.unidades.Alternativas.Unidad;

public class Scout extends Unidad {

	public Scout() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.SCOUT;
	}

	@Override
	protected void setearVida() {
		this.vida.set(150);
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


	
}
