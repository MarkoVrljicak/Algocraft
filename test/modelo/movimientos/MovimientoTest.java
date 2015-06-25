package modelo.movimientos;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import modelo.exception.CoordenadaInexistenteException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.Coordenada;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Marine;

import org.junit.Test;

public class MovimientoTest {

	@Test
	public void testUnidadMuertaNoSeMueve() 
			throws PropiedadNoExisteEnEstaUbicacion, DestinoInvalidoException, 
			FueraDeLimitesException, CoordenadaInexistenteException{
		Mapa mapa = new Mapa(3,3);
		Unidad unidad = new Marine();
		int danioCausado = 41;
		unidad.recibirDanio(danioCausado);
		Movimiento movimiento = new MovimientoTerrestre();
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		mapa.almacenar((Propiedad) unidad, origen);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(mapa.getPropiedadSuelo(origen), unidad);
	}
}
