package algocraft.unidades.protos;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.protos.AltoTemplario;

public class AltoTemplarioTest {

	@Test
	public void testCreoAltoTemplarioYControloVidaInicial(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(40,altoTemplario.getVida() );
	}
}
