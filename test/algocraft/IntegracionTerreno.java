package algocraft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Tierra;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class IntegracionTerreno {
	Coordenada coordenadaCualquiera = new Coordenada(2,3);
	
	@Test
	public void testTerrenoColocaYQuitaUnidadesConMetodosGenericos() throws DestinoInvalidoException {
		Terreno tierra = new Tierra(coordenadaCualquiera);
		Unidad unidadCaminante = new Marine();
		Unidad unidadVoladora = new NaveCiencia();
		
		tierra.almacenar(unidadCaminante);
		
		assertEquals(false, tierra.sePuedeCaminar());
		
		tierra.almacenar(unidadVoladora);
		
		assertEquals(false, tierra.sePuedeVolar());
		
//		tierra.borrarContenido(unidadCaminante);
//		
//		assertEquals(true, tierra.sePuedeCaminar());
//		
//		tierra.borrarContenido(unidadVoladora);
//		
//		assertEquals(true, tierra.sePuedeVolar());
		
		
		
	}
	
	

}
