package algocraft.unidades.Alternativas.terran;

import algocraft.ataques.Ataque;
import algocraft.ataques.AtaqueAereo;
import algocraft.ataques.AtaqueTerrestre;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Alternativas.Unidad;


public class Espectro extends Unidad{

	public Espectro() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.ESPECTRO;
	}

	@Override
	protected void setearVida() {
		this.vida.set(120);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;
	}

	@Override
	public boolean atacar(Terreno terrenoDestino, SectoresDeTerreno sector, int distancia) {
		Ataque ataque = null;
		int danioTerrestre = 8;
		int danioAereo = 20;
		int rango = 5;
		
		if (sector == SectoresDeTerreno.SUELO){
			ataque = new AtaqueTerrestre(danioTerrestre, rango);
		} else if (sector == SectoresDeTerreno.CIELO){
			ataque = new AtaqueAereo(danioAereo, rango);
		}
		
		return ataque.ejecutarAtaque(terrenoDestino, distancia);
	}



}
