package razas;
import java.util.Collection;
import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.Barraca;
import algocraft.construcciones.CentroDeMineral;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.DepositoDeSuministros;
import algocraft.construcciones.Fabrica;
import algocraft.construcciones.PuertoEstelar;
import algocraft.construcciones.Refineria;
import algocraft.creables.ValidadorDeCreaciones;
public class Terran extends Raza {
	
	private String nombre;
	
	public Terran(){
		nombre = "Terran";
		
		construcciones = new HashMap<String, ValidadorDeCreaciones>();
		this.construcciones.put("Centro De Mineral", new ValidadorDeCreaciones(new Recurso(50,0), new CentroDeMineral() ));
		this.construcciones.put("Barraca", new ValidadorDeCreaciones(new Recurso(150,0), new Barraca() ));
		this.construcciones.put("Deposito De Suministros", new ValidadorDeCreaciones(new Recurso(100,0), new DepositoDeSuministros() ));
		this.construcciones.put("Refineria", new ValidadorDeCreaciones(new Recurso(100,0), new Refineria() ));
		this.construcciones.put("Fabrica", new ValidadorDeCreaciones(new Recurso(200,100), new Fabrica() ));
		this.construcciones.put("Puerto Estelar", new ValidadorDeCreaciones(new Recurso(150,100), new PuertoEstelar() ));
		
	}
	
	public String getNombre(){
		return nombre;
	}

	protected boolean tengoConstruccion(String nombreDeConstruccion){
		return construcciones.containsKey(nombreDeConstruccion);
	}
	
	public Construccion construirConstruccion(Recurso recursosDisponibles, String nombreDeConstruccion) {
		
		if (tengoConstruccion(nombreDeConstruccion)){
			
			ValidadorDeCreaciones validador = construcciones.get(nombreDeConstruccion);
			return (Construccion) validador.crear(recursosDisponibles);
		}
		
		else {
			return null;
		}
	}
	
	public Collection<String> getListaDeConstrucciones(){
		return construcciones.keySet();
	}

	
}
