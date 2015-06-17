package algocraft.magias;

import java.util.Collection;
import java.util.Iterator;

import algocraft.mapa.terrenos.Terreno;
import algocraft.propiedad.Propiedad;

public class EMP extends AtaqueMagico{
	
	Collection<Terreno> area;
	public EMP(Collection<Terreno> area){
		this.area = area;
	}
	
	protected void afectarZona(Terreno terreno){
		Propiedad propiedad = terreno.getContenidoSuelo();
		if(propiedad != null){
			propiedad.quitarEnergia();
		}
		propiedad = terreno.getContenidoCielo();
		if(propiedad != null){
			propiedad.quitarEnergia();
		}
	}

	@Override
	public void ejecutar() {
		Iterator<Terreno> iter = area.iterator();
		while(iter.hasNext()){
			afectarZona(iter.next());
		}
	}

	@Override
	public boolean caduco() {
		return true;
	}

}
