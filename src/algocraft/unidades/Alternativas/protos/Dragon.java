package algocraft.unidades.Alternativas.protos;


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
		this.vida.set(100);
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
		int danio = 4;
		int rango = 4;
		this.danio = new Danio(danio, danio, rango, rango);
		
	}




}
