package algocraft.movimientos;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import algocraft.exception.CoordenadaInexistenteException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.propiedad.Propiedad;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;


public class MovimientoAereoTest {
	@Test
	public void testMovimientoTerrestreAVecinoDespejado() 
			throws CoordenadaInexistenteException, FueraDeLimitesException, DestinoInvalidoException {
		Mapa mapa = new Mapa(3,3);
		
		Unidad unidad = new NaveCiencia();
		
		Movimiento movimiento = new MovimientoAereo(); //no quiero depender de que la unidad lo tenga.
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		mapa.almacenar((Propiedad) unidad, origen);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(mapa.getPropiedadCielo(destino), unidad);
	}
	
	@Test
	public void testMovimientoTerrestreATierraMasLejanaConCaminoDespejado() 
			throws CoordenadaInexistenteException, FueraDeLimitesException, DestinoInvalidoException {
		Mapa mapa = new Mapa(3,3);
		
		Unidad unidad = new NaveCiencia();
		
		Movimiento movimiento = new MovimientoAereo(); //no quiero depender de que la unidad lo tenga.
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(3,3);
		
		mapa.almacenar((Propiedad) unidad, origen);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(mapa.getPropiedadCielo(destino), unidad);
	}
	
	@Test
	public void testUnidadNoLlegaSiElObjetivoEstaDemasiadoLejos() 
			throws CoordenadaInexistenteException, FueraDeLimitesException, DestinoInvalidoException {
		Mapa mapa = new Mapa(10,10);
		
		Unidad unidad = new NaveCiencia();
		
		Movimiento movimiento = new MovimientoAereo(); //no quiero depender de que la unidad lo tenga.
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(10,10);
		
		mapa.almacenar((Propiedad) unidad, origen);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(mapa.getPropiedadCielo(destino), null);
	}
	
	@Test
	public void testUnidadNoLlegaSiElObjetivoEstaDemasiadoLejosPeroTampocoSeQuedaEnElOrigen() 
			throws CoordenadaInexistenteException, FueraDeLimitesException, DestinoInvalidoException {
		Mapa mapa = new Mapa(10,10);
		
		Unidad unidad = new NaveCiencia();
		
		Movimiento movimiento = new MovimientoAereo(); //no quiero depender de que la unidad lo tenga.
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(10,10);
		
		mapa.almacenar((Propiedad) unidad, origen);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(null, mapa.getPropiedadCielo(origen));
	}
	
	@Test
	public void testUnidadNoLlegaSiElCaminoEstaObstruido() 
			throws CoordenadaInexistenteException, FueraDeLimitesException, DestinoInvalidoException {
		Mapa mapa = new Mapa(1,3);
		
		Unidad unidad = new NaveCiencia();
		Unidad obstruccion = new NaveCiencia();
		
		Movimiento movimiento = new MovimientoAereo(); //no quiero depender de que la unidad lo tenga.
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,3);
		
		mapa.almacenar((Propiedad) unidad, origen);
		mapa.almacenar((Propiedad) obstruccion, new Coordenada(1,2));
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(unidad, mapa.getPropiedadCielo(origen));
	}

	@Test
	public void testUnidadLlegaAunqueElCaminoEsteObstruidoPorTierra() 
			throws CoordenadaInexistenteException, FueraDeLimitesException, DestinoInvalidoException {
		Mapa mapa = new Mapa(1,3);
		
		Unidad unidad = new NaveCiencia();
		Unidad obstruccion = new Marine();
		
		Movimiento movimiento = new MovimientoAereo(); //no quiero depender de que la unidad lo tenga.
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,3);
		
		mapa.almacenar((Propiedad) unidad, origen);
		mapa.almacenar((Propiedad) obstruccion, new Coordenada(1,2));
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
		
		movimiento.ejecutar(camino, unidad);
		
		assertEquals(unidad, mapa.getPropiedadCielo(destino));
	}

}
