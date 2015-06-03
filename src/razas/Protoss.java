package razas;

import stats.Recurso;
import algocraft.construcciones.protos.Acceso;
import algocraft.creables.ValidadorDeRecursos;

public class Protoss extends Raza{

	public Protoss(){
		this.nombre = "Protoss";
		this.construcciones.put("Acceso", new ValidadorDeRecursos(new Recurso(150,0), new Acceso() ));
	}
	
}
