package algocraft.construcciones.terran;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.terran.Golliat;

public class Fabrica extends CreadorDeUnidades {

	public Fabrica() {
		this.nombre = "Fabrica";
		this.tiempoDeConstruccion = 12;
		this.vida.set(1250);
		unidades = new HashMap<String, ValidadorDePoblacion>();
		this.unidades.put("Golliat", new ValidadorDePoblacion(new Recurso(100,50), new Golliat() , 2 ));
	}

	@Override
	public Creable clonar() {
		return (new Fabrica());
	}

	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
	}

}
