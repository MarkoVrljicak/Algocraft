package algocraft.magias;

import java.util.Collection;
import java.util.Iterator;

import algocraft.mapa.terrenos.Terreno;
import algocraft.propiedad.Propiedad;

public class TormentaPsionica {
	
	Collection<Terreno> area;
	
	public TormentaPsionica(Collection<Terreno> area){
		this.area = area;
	}
	
	public void ejecutar(){
			
		Iterator<Terreno> iter = area.iterator();
		while(iter.hasNext()){
			atormentar(iter.next());
		}
	}
	
	private void atormentar(Terreno terreno){
		int danio = 100;
		Propiedad propiedad = terreno.getContenidoSuelo();
		if(propiedad != null){
			propiedad.recibirDanio(danio);
		}
		propiedad = terreno.getContenidoCielo();
		if(propiedad != null){
			propiedad.recibirDanio(danio);
		}
	}
}
