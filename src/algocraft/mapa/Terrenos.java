package algocraft.mapa;

import algocraft.mapa.terrenos.Aire;
import algocraft.mapa.terrenos.Minerales;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Tierra;
import algocraft.mapa.terrenos.Volcan;

public enum Terrenos {
	
	TIERRA{
		public Terreno crear(int i, int j){
			Coordenada coordenada = new Coordenada(i,j);
			return new Tierra(coordenada);
		}
	},
	AIRE{
		public Terreno crear(int i, int j){
			Coordenada coordenada = new Coordenada(i,j);
			return new Aire(coordenada);
		}
	},
	MINERALES{
		public Terreno crear(int i, int j){
			Coordenada coordenada = new Coordenada(i,j);
			return new Minerales(coordenada);
		}
	},
	VOLCAN{
		public Terreno crear(int i, int j){
			Coordenada coordenada = new Coordenada(i,j);
			return new Volcan(coordenada);
		}
	};
	
	abstract public Terreno crear(int i, int j);
}
