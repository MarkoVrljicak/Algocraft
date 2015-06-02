package algocraft.construcciones.protos;

import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;
import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.protos.NaveDeTransporte;
import algocraft.unidades.protos.Scout;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "PuertoEstelar";
		this.vida.set(600);
		this.tiempoDeConstruccion = 10;
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Scout", new ValidadorDeCreaciones(new Recurso(300,150), new Scout() ));
		this.unidades.put("Nave de Transporte", new ValidadorDeCreaciones(new Recurso(200,0), new NaveDeTransporte() ));
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
