package algocraft.mapa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.ActualizableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.terran.Marine;
import algocraft.unidades.Alternativas.terran.NaveCiencia;

public class DesplazadorTest {

	@Test
	public void testDesplazadorMueveUnidadPorTierra(){
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			desplazador.moverPorTierra(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, mapa.getActualizableSuelo(destino));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorTierraOrigenEstaVacio(){
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			desplazador.moverPorTierra(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getActualizableSuelo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoEstaOcupadoPorOtraUnidad() throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException{
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine1, origen);
			mapa.almacenarEnSuelo(marine2, destino);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, desplazador.moverPorTierra(marine1, destino));
		
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoNoEsTierra() throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException{
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad marine = new Marine();
		
		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 1, 2);
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false,	desplazador.moverPorTierra(marine, destino));
		
	}
	
	@Test
	public void testMapaMueveUnidadPorAire() throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException{
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		desplazador.moverPorCielo(nave, destino);
		
		assertEquals(nave, mapa.getActualizableCielo(destino));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorAireOrigenEstaVacio(){
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			desplazador.moverPorCielo(nave, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getActualizableCielo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorCieloSiDestinoEstaOcupadoPorOtraUnidad() throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException{
		Mapa mapa= new Mapa(2,2);
		Desplazador desplazador = new Desplazador(mapa);
		Unidad nave1 = new NaveCiencia();
		Unidad nave2 = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave1, origen);
			mapa.almacenarEnCielo(nave2, destino);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, desplazador.moverPorCielo(nave1, destino));
		
	}
}
