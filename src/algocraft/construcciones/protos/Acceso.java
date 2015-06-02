package algocraft.construcciones.protos;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.protos.Dragon;
import algocraft.unidades.protos.Zealot;


public class Acceso extends CreadorDeUnidades {

	public Acceso() {
		this.nombre = "Acceso";
		this.vida.set(500);
		this.tiempoDeConstruccion = 8;
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Zealot", new ValidadorDeCreaciones(new Recurso(100,0), new Zealot() ));
		this.unidades.put("Dragon", new ValidadorDeCreaciones(new Recurso(125,50), new Dragon() ));
	}
	
	
	@Override
	public Creable clonar() {
		return new Acceso();
	}


	@Override
	public void actualizar() {
		// COMPLETAR
		
	}

}
