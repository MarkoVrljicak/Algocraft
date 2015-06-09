package algocraft.unidades.Alternativas.terran;

import algocraft.ataques.Ataque;
import algocraft.ataques.AtaqueAereo;
import algocraft.ataques.AtaqueTerrestre;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Alternativas.Unidad;



public class Marine extends Unidad{

	public Marine() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.MARINE;
	}

	@Override
	protected void setearVida() {
		this.vida.set(40);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 1;
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 1;
	}

	@Override
	public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector, int distancia) {
		Ataque ataque = null;
		int danio = 6;
		int rango = 4;
		
		if (sector == SectoresDeTerreno.SUELO){
			ataque = new AtaqueTerrestre(danio, rango);
		} else if (sector == SectoresDeTerreno.CIELO){
			ataque = new AtaqueAereo(danio, rango);
		}
		
		return ataque.ejecutarAtaque(terrenoDestino, distancia);
	}


}
