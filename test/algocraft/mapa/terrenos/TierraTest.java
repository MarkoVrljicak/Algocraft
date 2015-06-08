package algocraft.mapa.terrenos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.creables.Creable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class TierraTest {
	Coordenada coordenadaGenerica = new Coordenada(1,1);

	@Test
	public void testTierraSePuedeCaminar() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		assertEquals(true, tierra.sePuedeCaminar() );
	}
	
	@Test
	public void testTierraNoSePuedeCaminarConSueloOcupado() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		Marine marine = new Marine();
		
		try {
			tierra.almacenarEnSuelo(marine);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, tierra.sePuedeCaminar() );
	}
	
	@Test
	public void testTierraSePuedeVolar() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		assertEquals(true, tierra.sePuedeVolar() );
	}
	
	@Test
	public void testTierraNoSePuedeVolarConCieloOcupado() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		Creable nave = new NaveCiencia();
		
		try {
			tierra.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, tierra.sePuedeVolar() );
	}
	
	@Test
	public void testTierraNoSePuedeMinar() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		assertEquals(false, tierra.sePuedeMinar() );
	}
	
	@Test
	public void testTierraNoTieneGas() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		assertEquals(false, tierra.tieneGas() );
	}
	
	@Test
	public void testTierraSePuedeEdificar() {
		Tierra tierra = new Tierra(coordenadaGenerica);
		assertEquals(true, tierra.sePuedeEdificar());
	}
	
	@Test
	public void testTierraInicializaConCieloVacio(){
		Tierra tierra = new Tierra(coordenadaGenerica);
		
		assertEquals(null, tierra.getContenidoCielo());
	}
	
	@Test
	public void testTierraInicializaConSueloVacio(){
		Tierra tierra = new Tierra(coordenadaGenerica);
		
		assertEquals(null, tierra.getContenidoSuelo());
	}
	
	@Test
	public void testColocaCreableEnCieloSiEstaVacio(){
		Tierra tierra = new Tierra(coordenadaGenerica);
		Creable nave = new NaveCiencia();
		
		try {
			tierra.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, tierra.getContenidoCielo());
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaCreableEnCieloSiEstaLleno() throws DestinoInvalidoException{
		Tierra tierra = new Tierra(coordenadaGenerica);
		Creable nave1 = new NaveCiencia();
		Creable nave2 = new NaveCiencia();
		
		tierra.almacenarEnCielo(nave1);
		tierra.almacenarEnCielo(nave2);
	}
	
	@Test
	public void testColocaCreableEnSueloSiEstaVacio(){
		Tierra tierra = new Tierra(coordenadaGenerica);
		Marine marine = new Marine();
		
		try {
			tierra.almacenarEnSuelo(marine);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, tierra.getContenidoSuelo());
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaCreableEnSueloSiEstaLleno() throws DestinoInvalidoException{
		Tierra tierra = new Tierra(coordenadaGenerica);
		Marine marine1 = new Marine();
		Marine marine2 = new Marine();
		
		tierra.almacenarEnSuelo(marine1);
		tierra.almacenarEnSuelo(marine2);
	}
	
	@Test
	public void testTierraSoportaUnidadEnTierraYOtraEnAireAlMismoTiempo() throws DestinoInvalidoException{
		Tierra tierra = new Tierra(coordenadaGenerica);
		Marine marine = new Marine();
		NaveCiencia nave = new NaveCiencia();
		
		tierra.almacenarEnSuelo(marine);
		tierra.almacenarEnCielo(nave);
		
		assertEquals(true, tierra.getContenidoSuelo() != null && tierra.getContenidoCielo() != null );
	}
	


}
