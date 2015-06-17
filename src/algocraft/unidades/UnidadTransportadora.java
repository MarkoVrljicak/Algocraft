package algocraft.unidades;

import java.util.ArrayList;
import java.util.Iterator;

import algocraft.exception.EspacioInsuficienteException;
import algocraft.exception.UnidadNoTransportableException;

public abstract class UnidadTransportadora extends Unidad{

	protected ArrayList<Unidad> unidadesTransportadas = new ArrayList<Unidad>();
	protected int capacidad = 8;
	
	public void subirUnidad(Unidad unidad) 
			throws EspacioInsuficienteException, UnidadNoTransportableException{
		if(unidad.soyVolador())
			throw new UnidadNoTransportableException();
		if (unidadesTransportadas.size()!= capacidad){
			unidadesTransportadas.add(unidad);
		}else
			throw new EspacioInsuficienteException();
	}
	
	public Unidad bajarUnidad(Unidad unidad){
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
	
	public int unidadesCargadas(){
		return unidadesTransportadas.size();
	}
	
	public ArrayList<Unidad> obtenerTranspotados(){
		return unidadesTransportadas;
		
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;
	}

}
