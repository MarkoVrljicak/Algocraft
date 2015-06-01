package algocraft.construcciones;

import java.util.HashMap;
import algocraft.Creable;
import algocraft.ValidadorDeCreaciones;
import algocraft.unidades.Golliat;

public class Fabrica extends CreadorDeUnidades {

	public Fabrica() {
		this.nombre = "Fabrica";
		this.tiempoDeConstruccion = 12;
		this.vidaMaxima.setVida(1250);
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Golliat", new ValidadorDeCreaciones(100, 50, new Golliat() ));
	}

	@Override
	public Creable clonar() {
		return (new Fabrica());
	}

}
