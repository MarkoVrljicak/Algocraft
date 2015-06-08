package algocraft.unidades.Alternativas.protos;


import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;
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
	public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector,
			int distancia) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
