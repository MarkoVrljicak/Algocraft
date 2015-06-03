package razas;

import stats.Recurso;
import algocraft.construcciones.terran.Barraca;
import algocraft.construcciones.terran.CentroDeMineral;
import algocraft.construcciones.terran.DepositoDeSuministros;
import algocraft.construcciones.terran.Fabrica;
import algocraft.construcciones.terran.PuertoEstelar;
import algocraft.construcciones.terran.Refineria;
import algocraft.creables.ValidadorDeRecursos;

public class Terran extends Raza {
	
	public Terran(){
		this.nombre = "Terran";
		this.construcciones.put("Centro De Mineral", new ValidadorDeRecursos(new Recurso(50,0), new CentroDeMineral() ));
		this.construcciones.put("Barraca", new ValidadorDeRecursos(new Recurso(150,0), new Barraca() ));
		this.construcciones.put("Deposito De Suministros", new ValidadorDeRecursos(new Recurso(100,0), new DepositoDeSuministros() ));
		this.construcciones.put("Refineria", new ValidadorDeRecursos(new Recurso(100,0), new Refineria() ));
		this.construcciones.put("Fabrica", new ValidadorDeRecursos(new Recurso(200,100), new Fabrica() ));
		this.construcciones.put("Puerto Estelar", new ValidadorDeRecursos(new Recurso(150,100), new PuertoEstelar() ));
	}
	
}
