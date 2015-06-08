package algocraft.unidades.Alternativas.terran;


import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;
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
	public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector,
			int distancia) {
		// TODO Auto-generated method stub
		return false;
	}

}

