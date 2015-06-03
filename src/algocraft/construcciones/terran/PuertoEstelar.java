package algocraft.construcciones.terran;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.terran.Espectro;
import algocraft.unidades.terran.NaveCiencia;
import algocraft.unidades.terran.NaveTransporte;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vida.set(1300);
		this.tiempoDeConstruccion = 10;
		this.unidades.put("Espectro", new ValidadorDePoblacion(new Recurso(150,50), new Espectro() , 2 ));
		this.unidades.put("Nave Ciencia", new ValidadorDePoblacion(new Recurso(100,225), new NaveCiencia() , 2 ));
		this.unidades.put("Nave Transporte", new ValidadorDePoblacion(new Recurso(100,100), new NaveTransporte() , 2 ));
	}

	@Override
	public Creable clonar() {
		return (new PuertoEstelar());
	}

	@Override
	public void actualizar() {
		disminuirTiempoDeConstruccion();
	}

}
