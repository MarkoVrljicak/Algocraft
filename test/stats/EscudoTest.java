package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscudoTest {

	@Test
	public void EscudoSeRegeneraElDiezPorciento() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(20);
		escudo.regenerar();
		
		assertEquals(90, escudo.actual());
	}
	
	@Test
	public void EscudoParaDeRegenerarseCuandoLlegaAMaximo() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.regenerar();
		
		assertEquals(100, escudo.actual());
	}
	
	@Test
	public void EscudoEstaVacioCuandoVidaEstaVacia() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(200);
		
		assertEquals(true, escudo.estoyVacio());
	}
	
	@Test
	public void EscudoNoEstaVacioCuandoVidaNoEstaVacia() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(100);
		
		assertEquals(false, escudo.estoyVacio());
	}
	
	
	@Test
	public void EscudoMuestraValorProtegido() {
		Stat vida = new Vida(80);
		Escudo escudo = new Escudo(100, vida);
		
		assertEquals(80, escudo.actualProtegida());
	}
}
