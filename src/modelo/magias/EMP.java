package modelo.magias;

import java.util.Collection;

import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;

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
		for(Terreno terreno :area){
			afectarZona(terreno);
		}
	}

	@Override
	public boolean caduco() {
		return true;
	}

}
