package modelo.ataques;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.factory.edificiosTerran.CreadorBarraca;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Marine;

import org.junit.Test;

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
