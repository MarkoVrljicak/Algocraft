package algocraft.construcciones;

import java.util.HashMap;
import algocraft.Creable;
import algocraft.ValidadorDeCreaciones;
import algocraft.unidades.Marine;

public class Barraca extends CreadorDeUnidades{
	
	public Barraca() {
		this.nombre = "Barraca";
		this.vidaMaxima.setVida(1000);
		this.tiempoDeConstruccion = 12;
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Marine", new ValidadorDeCreaciones(150, 0, (Creable) new Marine() ));
	}
	
	public Creable clonar(){
		return (new Barraca());
	}
	
}
