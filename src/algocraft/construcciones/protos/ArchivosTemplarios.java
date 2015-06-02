package algocraft.construcciones.protos;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.protos.AltoTemplario;


public class ArchivosTemplarios extends CreadorDeUnidades {

	public ArchivosTemplarios(){
		this.nombre= "Archivos Templarios";
		this.vida.set(500);
		this.tiempoDeConstruccion=9;
		this.unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put( "Alto Templario",new ValidadorDeCreaciones( new Recurso(50,150), new AltoTemplario() ) );
	}
	
	
	@Override
	public Creable clonar() {
		return new ArchivosTemplarios();
	}

}
