package razas;

import java.util.HashMap;

import algocraft.ValidadorDeCreaciones;
import algocraft.construcciones.Barraca;
import algocraft.construcciones.CentroDeMineral;
import algocraft.construcciones.DepositoDeSuministros;
import algocraft.construcciones.Fabrica;
import algocraft.construcciones.PuertoEstelar;
import algocraft.construcciones.Refineria;

public class Terran {
	
	private HashMap<String, ValidadorDeCreaciones> construcciones;
	
	Terran(){
		
		construcciones = new HashMap<String, ValidadorDeCreaciones>();
		this.construcciones.put("Centro De Mineral", new ValidadorDeCreaciones(50, 0, new CentroDeMineral() ));
		this.construcciones.put("Barraca", new ValidadorDeCreaciones(150, 0, new Barraca() ));
		this.construcciones.put("Deposito De Suministros", new ValidadorDeCreaciones(100, 0, new DepositoDeSuministros() ));
		this.construcciones.put("Refineria", new ValidadorDeCreaciones(100, 0, new Refineria() ));
		this.construcciones.put("Fabrica", new ValidadorDeCreaciones(200, 100, new Fabrica() ));
		this.construcciones.put("Puerto Estelar", new ValidadorDeCreaciones(150, 100, new PuertoEstelar() ));
		
	}

	protected boolean tengoConstruccion(String nombreDeConstruccion){
		return construcciones.containsKey(nombreDeConstruccion);
	}
	
	
}