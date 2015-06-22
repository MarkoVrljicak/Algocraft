package modelo;

import static org.junit.Assert.assertEquals;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Tierra;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Marine;
import modelo.unidades.terran.NaveCiencia;

import org.junit.Test;

public class IntegracionTerreno {
	Coordenada coordenadaCualquiera = new Coordenada(2,3);
	
	@Test
	public void testTerrenoColocaYQuitaUnidadesConMetodosGenericos() throws DestinoInvalidoException, PropiedadNoExisteEnEstaUbicacion {
		Terreno tierra = new Tierra(coordenadaCualquiera);
		Unidad unidadCaminante = new Marine();
		Unidad unidadVoladora = new NaveCiencia();
		
		tierra.almacenar(unidadCaminante);
		
		assertEquals(false, tierra.sePuedeCaminar());
		
		tierra.almacenar(unidadVoladora);
		
		assertEquals(false, tierra.sePuedeVolar());
		
		tierra.borrarContenido(unidadCaminante);
		
		assertEquals(true, tierra.sePuedeCaminar());
		
		tierra.borrarContenido(unidadVoladora);
		
		assertEquals(true, tierra.sePuedeVolar());
		
		
		
	}
	
	

}
