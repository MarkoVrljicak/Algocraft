package algocraft.construcciones.protos;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.protos.AltoTemplario;


public class ArchivosTemplarios extends CreadorDeUnidades {

	public ArchivosTemplarios(){
		this.nombre= "Archivos Templarios";
		this.vida.set(500);
		this.tiempoDeConstruccion=9;
		this.unidades = new HashMap<String, ValidadorDePoblacion>();
		this.unidades.put( "Alto Templario",new ValidadorDePoblacion( new Recurso(50,150), new AltoTemplario() , 2  ) );
	}
	
	
	@Override
	public Creable clonar() {
		return new ArchivosTemplarios();
	}


	@Override
	public void actualizar() {
		//COMPLETAR
	}

}
