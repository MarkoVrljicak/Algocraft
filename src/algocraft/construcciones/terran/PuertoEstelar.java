package algocraft.construcciones.terran;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.terran.Espectro;
import algocraft.unidades.terran.NaveCiencia;
import algocraft.unidades.terran.NaveTransporte;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vida.set(1300);
		this.tiempoDeConstruccion = 10;
		
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Espectro", new ValidadorDeCreaciones(new Recurso(150,50), new Espectro() ));
		this.unidades.put("Nave Ciencia", new ValidadorDeCreaciones(new Recurso(100,225), new NaveCiencia() ));
		this.unidades.put("Nave Transporte", new ValidadorDeCreaciones(new Recurso(100,100), new NaveTransporte() ));
	}

	@Override
	public Creable clonar() {
		return (new PuertoEstelar());
	}

	@Override
	public void actualizar() {
		//COMPLETAR
	}

}
