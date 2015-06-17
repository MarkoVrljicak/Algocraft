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
		Iterator<Terreno> iter = area.iterator();
		while(iter.hasNext()){
			afectarZona(iter.next(), 100);
		}
		turnosActivo++;
	}

	@Override
	public boolean caduco() {
		return (turnosActivo >= 2);
	}
	
	
}
