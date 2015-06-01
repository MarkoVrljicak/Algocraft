package algocraft.construcciones;

import java.util.HashMap;

import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.Espectro;
import algocraft.unidades.NaveCiencia;
import algocraft.unidades.NaveTransporte;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vida.set(1300);
		this.tiempoDeConstruccion = 10;
		
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Espectro", new ValidadorDeCreaciones(150, 100, new Espectro() ));
		this.unidades.put("Nave Ciencia", new ValidadorDeCreaciones(100, 225, new NaveCiencia() ));
		this.unidades.put("Nave Transporte", new ValidadorDeCreaciones(100, 100, new NaveTransporte() ));
	}

	@Override
	public Creable clonar() {
		return (new PuertoEstelar());
	}

}
