package algocraft.construcciones.terran;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.terran.Marine;

public class Barraca extends CreadorDeUnidades{
	
	public Barraca() {
		this.nombre = "Barraca";
		this.vida.set(1000);
		this.tiempoDeConstruccion = 12;
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Marine", new ValidadorDeCreaciones(new Recurso(50,0), new Marine() ));
	}
	
	public Creable clonar(){
		return (new Barraca());
	}

	@Override
	public void actualizar() {
		//COMPLETAR
	}
	
}
