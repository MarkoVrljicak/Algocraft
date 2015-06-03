package razas;

import stats.Recurso;
import algocraft.construcciones.protos.Acceso;
import algocraft.construcciones.protos.ArchivosTemplarios;
import algocraft.construcciones.protos.Asimilador;
import algocraft.construcciones.protos.NexoMineral;
import algocraft.construcciones.protos.Pilon;
import algocraft.construcciones.protos.PuertoEstelar;
import algocraft.creables.ValidadorDeRecursos;

public class Protoss extends Raza{

	public Protoss(){
		this.nombre = "Protoss";
		this.construcciones.put("Acceso", new ValidadorDeRecursos(new Recurso(150,0), new Acceso() ));
		this.construcciones.put("Archivos Templarios", new ValidadorDeRecursos(new Recurso(150,200), new ArchivosTemplarios() ));
		this.construcciones.put("Asimilador", new ValidadorDeRecursos(new Recurso(100,0), new Asimilador() ));
		this.construcciones.put("Nexo Mineral", new ValidadorDeRecursos(new Recurso(50,0), new NexoMineral() ));
		this.construcciones.put("Pilon", new ValidadorDeRecursos(new Recurso(100,0), new Pilon() ));
		this.construcciones.put("Puerto Estelar", new ValidadorDeRecursos(new Recurso(150,150), new PuertoEstelar() ));
	}
	
}
