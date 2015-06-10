package algocraft.unidades;

import java.util.ArrayList;
import java.util.Iterator;
import algocraft.ataques.Danio;

public abstract class UnidadTransportadora extends Unidad{

	protected ArrayList<Unidad> unidadesTransportadas = new ArrayList<Unidad>();
	protected int capacidad = 8;
	
	protected void subirUnidad(Unidad unidad){
		if (unidadesTransportadas.size() != capacidad){
			unidadesTransportadas.add(unidad);
		}
	}
	
	protected Unidad bajarUnidad(Unidad unidad){
		Iterator<Unidad> itUnidades = unidadesTransportadas.iterator();	
		while(itUnidades.hasNext()){
			Unidad unaUnidad = itUnidades.next();
			if (unaUnidad == unidad){
				unidadesTransportadas.remove(unaUnidad);
				return unaUnidad;				
			}
		}
		return null;
	}
	
	protected int unidadesCargadas(){
		return unidadesTransportadas.size();
	}
	
	@Override
	protected void setearDanio() {
		this.danio = new Danio(0,0,0,0);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;
	}

}
