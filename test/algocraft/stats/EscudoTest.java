package algocraft.stats;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.stats.Escudo;
import algocraft.stats.Stat;
import algocraft.stats.Vida;

public class EscudoTest {

	@Test
	public void testEscudoSeRegeneraElDiezPorciento() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(20);
		escudo.regenerar();
		
		assertEquals(90, escudo.actual());
	}
	
	@Test
	public void testEscudoParaDeRegenerarseCuandoLlegaAMaximo() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.regenerar();
		
		assertEquals(100, escudo.actual());
	}
	
	@Test
	public void testEscudoEstaVacioCuandoVidaEstaVacia() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(200);
		
		assertEquals(true, escudo.estoyVacio());
	}
	
	@Test
	public void testEscudoNoEstaVacioCuandoVidaNoEstaVacia() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(100);
		
		assertEquals(false, escudo.estoyVacio());
	}
	
	
	@Test
	public void testEscudoMuestraValorProtegido() {
		Stat vida = new Vida(80);
		Escudo escudo = new Escudo(100, vida);
		
		assertEquals(80, escudo.actualProtegida());
	}
	
	@Test
	public void testEscudoGuardaVidaVacia(){
		//Este caso se da en la alucinacion.
		Stat vida = new Vida(0);
		Escudo escudo = new Escudo(100, vida);
		
		assertEquals(0, escudo.actualProtegida());
	}
}
