package algocraft.construcciones;

import java.util.HashMap;

import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.*;


public class Acceso extends CreadorDeUnidades {

	public Acceso() {
		this.nombre = "Acceso";
		this.vida.set(500);
		this.tiempoDeConstruccion = 8;
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Zealot", new ValidadorDeCreaciones(100, 0, new Zealot() ));
		this.unidades.put("Dragon", new ValidadorDeCreaciones(125,50, new Dragon() ));
	}
	
	
	@Override
	public Creable clonar() {
		// TODO Auto-generated method stub
		return null;
	}

}
