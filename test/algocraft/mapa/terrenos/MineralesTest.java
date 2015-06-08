package algocraft.mapa.terrenos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construccionesAlternativas.Actualizable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.unidades.Alternativas.terran.Marine;
import algocraft.unidades.Alternativas.terran.NaveCiencia;

public class MineralesTest {
	Coordenada coordenadaGenerica = new Coordenada(1,1);

	@Test
	public void testMineralesNoSePuedeCaminar() {
		Minerales minerales = new Minerales(coordenadaGenerica);
		assertEquals(false, minerales.sePuedeCaminar());
	}
	
	@Test
	public void testMineralesSePuedeVolar() {
		Minerales minerales = new Minerales(coordenadaGenerica);
		assertEquals(true, minerales.sePuedeVolar());
	}
	
	@Test
	public void testMineralesNoSePuedeVolarSiEstaLleno() {
		Minerales minerales = new Minerales(coordenadaGenerica);
		Actualizable nave = new NaveCiencia();
		
		try {
			minerales.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, minerales.sePuedeVolar());
	}
	
	@Test
	public void testMineralesSePuedenMinar() {
		Minerales minerales = new Minerales(coordenadaGenerica);
		assertEquals(true, minerales.sePuedeMinar());
	}
	
	@Test
	public void testMineralesNoTienenGas() {
		Minerales minerales = new Minerales(coordenadaGenerica);
		assertEquals(false, minerales.tieneGas());
	}
	
	@Test
	public void testMineralesNoSePuedeEdificar() {
		Minerales minerales = new Minerales(coordenadaGenerica);
		assertEquals(false, minerales.sePuedeEdificar());
	}
	
	@Test
	public void testMineralesInicializaConCieloVacio(){
		Minerales minerales = new Minerales(coordenadaGenerica);
		
		assertEquals(null, minerales.getContenidoCielo());
	}
	
	@Test
	public void testMineralesInicializaConSueloVacio(){
Minerales minerales = new Minerales(coordenadaGenerica);
		
		assertEquals(null, minerales.getContenidoSuelo());
	}
	
	@Test
	public void testColocaActualizableEnCieloSiEstaVacio(){
		Minerales minerales = new Minerales(coordenadaGenerica);
		Actualizable nave = new NaveCiencia();
		
		try {
			minerales.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, minerales.getContenidoCielo());
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaActualizableEnCieloSiEstaLleno() throws DestinoInvalidoException{
		Minerales minerales = new Minerales(coordenadaGenerica);
		Actualizable nave1 = new NaveCiencia();
		Actualizable nave2 = new NaveCiencia();
		
		minerales.almacenarEnCielo(nave1);
		minerales.almacenarEnCielo(nave2);
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaActualizableEnTierraAunqueEsteVacio() throws DestinoInvalidoException{
		Minerales minerales = new Minerales(coordenadaGenerica);
		Actualizable marine = new Marine();
		
		minerales.almacenarEnSuelo(marine);
	}
	

}
