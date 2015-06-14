package algocraft.mapa.terrenos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.propiedad.Propiedad;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class VolcanTest {
	Coordenada coordenadaGenerica = new Coordenada(1,1);

	@Test
	public void testVolcanNoSePuedeCaminar() {
		Volcan volcan = new Volcan(coordenadaGenerica);
		assertEquals(false, volcan.sePuedeCaminar());
	}

	@Test
	public void testVolcanSePuedeVolar() {
		Volcan volcan = new Volcan(coordenadaGenerica);
		assertEquals(true, volcan.sePuedeVolar());
	}
	
	@Test
	public void testMineralesNoSePuedeVolarSiEstaLleno() {
		Volcan volcan = new Volcan(coordenadaGenerica);
		Propiedad nave = new NaveCiencia();
		
		try {
			volcan.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, volcan.sePuedeVolar());
	}
	
	@Test
	public void testVolcanNoSePuedeMinar() {
		Volcan volcan = new Volcan(coordenadaGenerica);
		assertEquals(false, volcan.sePuedeMinar());
	}
	
	@Test
	public void testVolcanTieneGas() {
		Volcan volcan = new Volcan(coordenadaGenerica);
		assertEquals(true, volcan.tieneGas());
	}
	
	@Test
	public void testVolcanNoSePuedeEdificar() {
		Volcan volcan = new Volcan(coordenadaGenerica);
		assertEquals(false, volcan.sePuedeEdificar());
	}
	
	@Test
	public void testVolcanInicializaConCieloVacio(){
		Volcan volcan = new Volcan(coordenadaGenerica);
		
		assertEquals(null, volcan.getContenidoCielo());
	}
	
	@Test
	public void testVolcanInicializaConSueloVacio(){
		Volcan volcan = new Volcan(coordenadaGenerica);

		assertEquals(null, volcan.getContenidoSuelo());
	}
	
	@Test
	public void testColocaActualizableEnCieloSiEstaVacio(){
		Volcan volcan = new Volcan(coordenadaGenerica);
		Propiedad nave = new NaveCiencia();
		
		try {
			volcan.almacenarEnCielo(nave);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, volcan.getContenidoCielo());
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaActualizableEnCieloSiEstaLleno() throws DestinoInvalidoException{
		Volcan volcan = new Volcan(coordenadaGenerica);
		Propiedad nave1 = new NaveCiencia();
		Propiedad nave2 = new NaveCiencia();
		
		volcan.almacenarEnCielo(nave1);
		volcan.almacenarEnCielo(nave2);
	}
	
	@Test (expected = DestinoInvalidoException.class)
	public void testNoColocaActualizableEnTierraAunqueEsteVacio() throws DestinoInvalidoException{
		Volcan volcan = new Volcan(coordenadaGenerica);
		Propiedad marine = new Marine();
		
		volcan.almacenarEnSuelo(marine);
	}
	
}
