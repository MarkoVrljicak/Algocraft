package algocraft.construcciones.protos;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.protos.Dragon;
import algocraft.unidades.protos.Zealot;


public class Acceso extends CreadorDeUnidades {

	public Acceso() {
		this.nombre = "Acceso";
		this.vida.set(500);
		this.tiempoDeConstruccion = 8;
		unidades = new HashMap<String, ValidadorDePoblacion>();
		this.unidades.put("Zealot", new ValidadorDePoblacion(new Recurso(100,0), new Zealot() , 2 ));
		this.unidades.put("Dragon", new ValidadorDePoblacion(new Recurso(125,50), new Dragon() , 2 ));
	}
	
	
	@Override
	public Creable clonar() {
		return new Acceso();
	}


	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
	}

}
