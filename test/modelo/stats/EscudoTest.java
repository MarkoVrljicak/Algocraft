package modelo.stats;

import static org.junit.Assert.*;
import modelo.stats.Escudo;
import modelo.stats.Stat;
import modelo.stats.Vida;

import org.junit.Test;

public class EscudoTest {
	
	private static final int timpoDeRetraso = 2;//copiado de la clase escudo

	@Test
	public void testEscudoNoSeRegeneraRecienAtacado() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(10);
		escudo.regenerar();
		
		assertEquals(90, escudo.actual());
	}
	
	@Test
	public void testEscudoSeRegeneraElDiezPorcientoPasadoElTiempoDeRetraso() {
		Stat vida = new Vida(100);
		Escudo escudo = new Escudo(100, vida);
		
		escudo.disminuir(20);
		for(int turnos = 1 ; turnos<=timpoDeRetraso ; turnos ++)
			escudo.regenerar();
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
