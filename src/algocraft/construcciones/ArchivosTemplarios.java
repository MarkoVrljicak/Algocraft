package algocraft.construcciones;

import java.util.HashMap;

import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.AltoTemplario;


public class ArchivosTemplarios extends CreadorDeUnidades {

	public ArchivosTemplarios(){
		this.nombre= "Archivos Templarios";
		this.vida.set(500);
		this.tiempoDeConstruccion=9;
		this.unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put( "Alto Templario",new ValidadorDeCreaciones( 50, 150, new AltoTemplario() ) );
	}
	
	
	@Override
	public Creable clonar() {
		
		return new ArchivosTemplarios();
	}

}
