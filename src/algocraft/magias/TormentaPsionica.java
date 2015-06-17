package algocraft.magias;

import java.util.Collection;
import java.util.Iterator;

import algocraft.mapa.terrenos.Terreno;

public class TormentaPsionica extends AtaqueMagico{
	
	int turnosActivo = 0;
	Collection<Terreno> area;
	
	public TormentaPsionica(Collection<Terreno> area){
		this.area = area;
	}
	
	public void ejecutar(){
		int danio = 100;
		Iterator<Terreno> iter = area.iterator();
		while(iter.hasNext()){
			afectarZona(iter.next(), danio);
		}
		turnosActivo++;
	}

	@Override
	public boolean caduco() {
		return (turnosActivo >= 2);
	}
	
	
}
