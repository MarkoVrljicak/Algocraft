package algocraft.ataques;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.factory.edificiosTerran.CreadorBarraca;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;

public class DaniableTest {

	@Test
	public void testVidaDeUnidadEsDaniada(){
		int vidaMarine = 40;
		int danioCausado = 20;
		
		Unidad marine = new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(vidaMarine - danioCausado,marine.getVida());
	}
	
	@Test
	public void testUnidadMatada(){
		int danioCausado = 40;
		
		Unidad marine = new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(true ,marine.estoyMuerto());
	}
	
	@Test
	public void testVidaDeEdificioEsDaniada(){
		int vidaBarraca = 1000;
		int danioCausado = 20;
		
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		barraca.recibirDanio(danioCausado);
		
		assertEquals(vidaBarraca - danioCausado, barraca.getVida());
	}
	
	@Test
	public void testEdificioDestruido(){
		int danioCausado = 1000;
		
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		barraca.recibirDanio(danioCausado);
		
		assertEquals(true, barraca.estoyMuerto());
	}
	

}
