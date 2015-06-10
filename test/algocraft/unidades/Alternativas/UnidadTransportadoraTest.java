package algocraft.unidades.Alternativas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.Alternativas.terran.Golliat;
import algocraft.unidades.Alternativas.terran.Marine;
import algocraft.unidades.Alternativas.terran.NaveTransporte;
import algocraft.unidades.Alternativas.terran.UnidadesTerran;

public class UnidadTransportadoraTest {

	private static final UnidadesTerran nombreMarine = UnidadesTerran.MARINE;
	
	@Test
	public void testNaveSubeAUnidad(){
		UnidadTransportadora nave = new NaveTransporte();
		Unidad marine = new Marine();
		
		nave.subirUnidad(marine);
		
		assertEquals(1, nave.unidadesCargadas());
	}
	
	@Test
	public void testNaveSubeAMuchasUnidadesPeroSoloHastaSuCapacidad(){
		UnidadTransportadora nave = new NaveTransporte();
		
		for(int i = 0; i<10; i++){
			Unidad marine = new Marine();
			nave.subirUnidad(marine);
		}
		
		assertEquals(8, nave.unidadesCargadas());
	}
	
	@Test
	public void testNaveSubeAUnidadYLuegoLaBaja(){
		UnidadTransportadora nave = new NaveTransporte();
		Unidad marine = new Marine();
		
		nave.subirUnidad(marine);
		
		assertEquals(1, nave.unidadesCargadas());
		
		Unidad unidadDescargada = nave.bajarUnidad(marine);
		
		assertEquals(unidadDescargada,marine);
		assertEquals(nombreMarine, marine.getNombre());
	}
	
	@Test
	public void testNaveSubeAUnidadesDeIgualTipoYLuegoLasBaja(){
		UnidadTransportadora nave = new NaveTransporte();
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		nave.subirUnidad(marine1);
		nave.subirUnidad(marine2);
		assertEquals(2, nave.unidadesCargadas());
		
		Unidad unidadDescargada1 = nave.bajarUnidad(marine2);
		assertEquals(unidadDescargada1,marine2);
		
		Unidad unidadDescargada2 = nave.bajarUnidad(marine1);
		assertEquals(unidadDescargada2,marine1);
	}
	
	@Test
	public void testNaveSubeAUnidadesDeDistintoTipoYLuegoLasBaja(){
		UnidadTransportadora nave = new NaveTransporte();
		Unidad marine = new Marine();
		Unidad golliat = new Golliat();
		
		nave.subirUnidad(marine);
		nave.subirUnidad(golliat);
		assertEquals(2, nave.unidadesCargadas());
		
		Unidad unidadDescargada1 = nave.bajarUnidad(golliat);
		assertEquals(unidadDescargada1,golliat);
		
		Unidad unidadDescargada2 = nave.bajarUnidad(marine);
		assertEquals(unidadDescargada2,marine);
	}
	
}
