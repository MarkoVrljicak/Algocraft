package algocraft.construcciones;

import java.util.HashMap;
import algocraft.Creable;
import algocraft.ValidadorDeCreaciones;
import algocraft.unidades.Espectro;
import algocraft.unidades.NaveCiencia;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vidaMaxima.setVida(1300);
		this.tiempoDeConstruccion = 10;
		
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Espectro", new ValidadorDeCreaciones(150, 100, new Espectro() ));
		this.unidades.put("Nave Ciencia", new ValidadorDeCreaciones(100, 225, new NaveCiencia() ));
	}

	@Override
	public Creable clonar() {
		return (new PuertoEstelar());
	}

}
