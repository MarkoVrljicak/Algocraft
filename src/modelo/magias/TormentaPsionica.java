package modelo.magias;

import java.util.Collection;

import modelo.mapa.terrenos.Terreno;

public class TormentaPsionica extends AtaqueMagico{
	
	int turnosActivo = 0;
	Collection<Terreno> area;
	
	public TormentaPsionica(Collection<Terreno> area){
		this.area = area;
	}
	
	public void ejecutar(){
		int danio = 100;
		for(Terreno terreno : area){
			afectarZona(terreno, danio);
		}
		turnosActivo++;
	}

	@Override
	public boolean caduco() {
		return (turnosActivo >= 2);
	}
	
	
}
