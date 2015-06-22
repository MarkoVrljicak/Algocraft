package modelo.unidades.protos;

import static org.junit.Assert.assertEquals;
import modelo.unidades.Unidad;
import modelo.unidades.protos.Dragon;
import modelo.unidades.terran.Espectro;
import modelo.unidades.terran.Marine;

import org.junit.Assert;
import org.junit.Test;


public class DragonTest {
	
	@Test
	public void testVerVidaInicialDragon(){
		
		Dragon dragon= new Dragon();
		
		Assert.assertEquals(100,dragon.getVida());
	}
	
	@Test
	public void testDragonNoEsVolador(){
		Dragon dragon = new Dragon();
		assertEquals(false, dragon.soyVolador());
	}
	
	@Test
	public void testSuminstrosDragonEs2(){
		Dragon dragon = new Dragon();
		
		assertEquals(2,dragon.getSuministros() );
	}
	
	@Test
	public void testMovimientosDragonEmpiezaEn4(){
		Dragon dragon = new Dragon();
		
		assertEquals(4,dragon.getMovimientos());
	}
	
	@Test
	public void testDragonInflige20DeDanioATierra(){
		int vidaMarine = 40;
		int danioDragon = 20;
		int distanciaAtaque = 1;
		
		Dragon dragon = new Dragon();
		Unidad marine = new Marine();
		dragon.atacar(marine, distanciaAtaque);
		
		assertEquals(20, vidaMarine - danioDragon );
	}
	
	@Test
	public void testDragonInflige20DeDanioAAire(){
		int vidaEspectro = 120;
		int danioDragon = 20;
		int distanciaAtaque = 1;
		
		Dragon dragon = new Dragon();
		Unidad espectro = new Espectro();
		dragon.atacar(espectro, distanciaAtaque);
		
		assertEquals(100, vidaEspectro - danioDragon );
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 6;
		Dragon dragon= new Dragon();
		
		assertEquals(true, dragon.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			dragon.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, dragon.enConstruccion());
	}
}
