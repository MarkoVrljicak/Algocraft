package algocraft.unidades.Alternativas.protos;

import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;
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
		this.vida.set(40);
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
	public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector,
			int distancia) {
		// TODO Auto-generated method stub
		return false;
	}

	



	

	
}
