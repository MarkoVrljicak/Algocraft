//package razas;
//
//import stats.Recurso;
//import algocraft.construccionesAlternativas.terran.Barraca;
//import algocraft.construccionesAlternativas.terran.CentroDeMineral;
//import algocraft.construccionesAlternativas.terran.DepositoDeSuministros;
//import algocraft.construccionesAlternativas.terran.Fabrica;
//import algocraft.construccionesAlternativas.terran.PuertoEstelar;
//import algocraft.construccionesAlternativas.terran.Refineria;
//import algocraft.creables.ValidadorDeRecursos;
//
//public class Terran extends Raza {
//	
//	public Terran(){
//		this.nombre = "Terran";
//		this.construcciones.put("Centro De Mineral", new ValidadorDeRecursos(new Recurso(50,0), new CentroDeMineral() ));
//		this.construcciones.put("Barraca", new ValidadorDeRecursos(new Recurso(150,0), new Barraca() ));
//		this.construcciones.put("Deposito De Suministros", new ValidadorDeRecursos(new Recurso(100,0), new DepositoDeSuministros() ));
//		this.construcciones.put("Refineria", new ValidadorDeRecursos(new Recurso(100,0), new Refineria() ));
//		this.construcciones.put("Fabrica", new ValidadorDeRecursos(new Recurso(200,100), new Fabrica() ));
//		this.construcciones.put("Puerto Estelar", new ValidadorDeRecursos(new Recurso(150,100), new PuertoEstelar() ));
//	}
//	
//}
