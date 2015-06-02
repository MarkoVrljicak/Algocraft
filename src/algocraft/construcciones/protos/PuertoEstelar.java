package algocraft.construcciones.protos;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.protos.NaveDeTransporte;
import algocraft.unidades.protos.Scout;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "PuertoEstelar";
		this.vida.set(600);
		this.tiempoDeConstruccion = 10;
		unidades = new HashMap<String, ValidadorDePoblacion>();
		this.unidades.put("Scout", new ValidadorDePoblacion(new Recurso(300,150), new Scout(), 3 ));
		this.unidades.put("Nave de Transporte", new ValidadorDePoblacion(new Recurso(200,0), new NaveDeTransporte() , 2 ));
	}
	
	@Override
	public Creable clonar() {
		return new PuertoEstelar();
	}

	@Override
	public void actualizar() {
		//COMPLETAR
	}

}
