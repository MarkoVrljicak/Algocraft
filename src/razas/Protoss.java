package razas;

import stats.Recurso;
import algocraft.construcciones.protos.Acceso;
import algocraft.construcciones.protos.ArchivosTemplarios;
import algocraft.creables.ValidadorDeRecursos;

public class Protoss extends Raza{

	public Protoss(){
		this.nombre = "Protoss";
		this.construcciones.put("Acceso", new ValidadorDeRecursos(new Recurso(150,0), new Acceso() ));
		this.construcciones.put("Archivos Templarios", new ValidadorDeRecursos(new Recurso(150,200), new ArchivosTemplarios() ));
		
	}
	
}
