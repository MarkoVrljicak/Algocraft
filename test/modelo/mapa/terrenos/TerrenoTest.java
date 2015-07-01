package modelo.mapa.terrenos;

import static org.junit.Assert.assertEquals;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.Coordenada;
import modelo.unidades.terran.Espectro;
import modelo.unidades.terran.Marine;

import org.junit.Test;

public class TerrenoTest {

	@Test
	public void testTerrenoLimpiaUnMuertoEnTierra() throws DestinoInvalidoException, PropiedadNoExisteEnEstaUbicacion {
		Terreno unTerreno = new Tierra(new Coordenada(1,1));
		Marine marine = new Marine();
		
		unTerreno.almacenarEnSuelo(marine);
		marine.recibirDanio(40);
		unTerreno.limpiarMuertos();
		
		assertEquals(true, unTerreno.sePuedeCaminar());
		
	}
	
	@Test
	public void testTerrenoLimpiaUnMuertoEnCielo() throws DestinoInvalidoException, PropiedadNoExisteEnEstaUbicacion {
		Terreno unTerreno = new Tierra(new Coordenada(1,1));
		Espectro espectro = new Espectro();
		
		unTerreno.almacenarEnCielo(espectro);
		espectro.recibirDanio(999999);
		unTerreno.limpiarMuertos();
		
		assertEquals(true, unTerreno.sePuedeVolar());
		
	}
	
	@Test
	public void testTerrenoLimpiaDosMuertos() throws DestinoInvalidoException, PropiedadNoExisteEnEstaUbicacion {
		Terreno unTerreno = new Tierra(new Coordenada(1,1));
		Marine marine = new Marine();
		Espectro espectro = new Espectro();
		
		unTerreno.almacenarEnSuelo(marine);
		unTerreno.almacenarEnCielo(espectro);
		espectro.recibirDanio(999999);
		marine.recibirDanio(40);
		unTerreno.limpiarMuertos();
		
		assertEquals(true, unTerreno.sePuedeVolar() && unTerreno.sePuedeCaminar());
		
	}

}
