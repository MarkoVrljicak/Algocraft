package algocraft.propiedad;

import algocraft.Interfaces.Actualizable;
import algocraft.Interfaces.Daniable;
import algocraft.ataques.Ataques;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.terrenos.Terreno;

abstract public class Propiedad implements Daniable, Actualizable{

	abstract public boolean soyVolador();
	
	public Ataques comoAtacarme(){
		boolean soyVolador = this.soyVolador();
		if(soyVolador){
			return Ataques.ATAQUE_NORMAL_AEREO;
		} else {
			return Ataques.ATAQUE_NORMAL_TERRESTRE;
		}
	}

	public void almacenarme(Terreno terreno) throws DestinoInvalidoException {
		if(this.soyVolador()){
			if(terreno.getContenidoCielo() != null) throw new DestinoInvalidoException();
			terreno.almacenarEnCielo(this);
		} else {
			if(terreno.getContenidoSuelo() != null) throw new DestinoInvalidoException();
			terreno.almacenarEnSuelo(this);
		}
		
	}

	abstract public void quitarEnergia();
	
}
