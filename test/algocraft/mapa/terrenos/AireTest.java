package algocraft.mapa.terrenos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.Interfaces.Actualizable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class AireTest {
	Coordenada coordenadaGenerica = new Coordenada(1,1);

	
	@Test
	public void testNombreDeAireEsElEsperado(){
		Aire aire = new Aire(coordenadaGenerica);
		
		assertEquals(Terrenos.AIRE, aire.getNombre());
	}
	
	@Test
	public void testAireNoSePuedeCaminar() {
		Aire aire = new Aire(coordenadaGenerica);
		assertEquals(false, aire.sePuedeCaminar());
	}

	@Test
	public void testAireSePuedeVolar() {
		Aire aire = new Aire(coordenadaGenerica);
		assertEquals(true, aire.sePuedeVolar());
	}
	
	@Test
	public void testAireNoSePuedeVolarSiEstaLleno() {
		Aire aire = new Aire(coordenadaGenerica);
		Actualizable nave = new NaveCiencia();
		
		try {
			aire.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, aire.sePuedeVolar());
	}
	
	@Test
	public void testAireNoSePuedeMinar() {
		Aire aire = new Aire(coordenadaGenerica);
		assertEquals(false, aire.sePuedeMinar());
	}
	
	@Test
	public void testAireNoTieneGas() {
		Aire aire = new Aire(coordenadaGenerica);
		assertEquals(false, aire.tieneGas());
	}
	
	@Test
	public void testAireNoSePuedeEdificar() {
		Aire aire = new Aire(coordenadaGenerica);
		assertEquals(false, aire.sePuedeEdificar());
	}
	
	@Test
	public void testAireInicializaConCieloVacio(){
		Aire aire = new Aire(coordenadaGenerica);
		
		assertEquals(null, aire.getContenidoCielo());
	}
	
	@Test
	public void testAireInicializaConSueloVacio(){
		Aire aire = new Aire(coordenadaGenerica);
		
		assertEquals(null, aire.getContenidoSuelo());
	}
	
	@Test
	public void testColocaActualizableEnCieloSiEstaVacio(){
		Aire aire = new Aire(coordenadaGenerica);
		Actualizable nave = new NaveCiencia();
		
		try {
			aire.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, aire.getContenidoCielo());
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaActualizableEnCieloSiEstaLleno() throws DestinoInvalidoException{
		Aire aire = new Aire(coordenadaGenerica);
		Actualizable nave1 = new NaveCiencia();
		Actualizable nave2 = new NaveCiencia();
		
		aire.almacenarEnCielo(nave1);
		aire.almacenarEnCielo(nave2);
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaActualizableEnTierraAunqueEsteVacio() throws DestinoInvalidoException{
		Aire aire = new Aire(coordenadaGenerica);
		Actualizable marine = new Marine();
		
		aire.almacenarEnSuelo(marine);
	}
	
	
	
}
