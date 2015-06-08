package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscudoTest {

	@Test
	public void EscudoSeRegeneraElDiezPorciento() {
		Escudo escudo = new Escudo();
		escudo.set(100);
		
		escudo.disminuir(20);
		escudo.regenerar();
		
		assertEquals(90, escudo.actual());
	}
	
	@Test
	public void EscudoParaDeRegenerarseCuandoLlegaAMaximo() {
		Escudo escudo = new Escudo();
		escudo.set(100);
		
		escudo.regenerar();
		
		assertEquals(100, escudo.actual());
	}

}
