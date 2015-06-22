package modelo.unidades.protos;

import static org.junit.Assert.assertEquals;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Aire;
import modelo.mapa.terrenos.Terreno;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;
import modelo.unidades.protos.Alucinacion;
import modelo.unidades.protos.Scout;
import modelo.unidades.protos.Zealot;

import org.junit.Test;

public class AlucinacionTest {

	@Test
	public void testAlucinacionTieneEscudoDeUnidadOriginal() {
		Unidad unidadReal = new Zealot();
		Unidad alucinacion = new Alucinacion(unidadReal);
		
		assertEquals(unidadReal.getVitalidadMaxima(), alucinacion.getVitalidadMaxima());
	}
	
	@Test
	public void testAlucinacionMuereCuandoSeAcabaEscudo() {
		int escudoZealot = 60;
		Unidad unidadReal = new Zealot();
		Unidad alucinacion = new Alucinacion(unidadReal);
		
		alucinacion.recibirDanio(escudoZealot);
		
		assertEquals(true, alucinacion.estoyMuerto());
	}
	
	@Test
	public void testAlucinacionNoMuereCuandoSiNoSeAcabaEscudo() {
		int escudoZealot = 60;
		Unidad unidadReal = new Zealot();
		Unidad alucinacion = new Alucinacion(unidadReal);
		
		alucinacion.recibirDanio(escudoZealot-1);
		
		assertEquals(false, alucinacion.estoyMuerto());
	}
	
	@Test
	public void testAlucinacionSeMueveComoUnidadOriginalSiOriginalEsTerrestre(){
		Terreno aire = new Aire(new Coordenada(1,1));
		
		Unidad unidadReal = new Zealot();
		Unidad alucinacion = new Alucinacion(unidadReal);
		
		assertEquals(unidadReal.puedoMoverme(aire), alucinacion.puedoMoverme(aire));
	}
	
	@Test
	public void testAlucinacionSeMueveComoUnidadOriginalSiOriginalEsAerea(){
		Terreno aire = new Aire(new Coordenada(1,1));
		
		Unidad unidadReal = new Scout();
		Unidad alucinacion = new Alucinacion(unidadReal);
		
		assertEquals(unidadReal.puedoMoverme(aire), alucinacion.puedoMoverme(aire));
	}
	
	@Test
	public void testAlucinacionNoHaceDanio(){
		int distanciaAtaque = 1;
		Unidad unidadReal = new Scout();
		int vidaOriginal = unidadReal.getVida();
		UnidadAtacante alucinacion = new Alucinacion(unidadReal);
		
		alucinacion.atacar(unidadReal, distanciaAtaque);
		
		assertEquals(vidaOriginal, unidadReal.getVida());
	}
	
	@Test
	public void testAlucinacionNoSeMuereCuandoMuereUnidadOriginal(){
		Unidad unidadReal = new Scout();
		UnidadAtacante alucinacion = new Alucinacion(unidadReal);
		
		unidadReal.recibirDanio(1000000);
		
		assertEquals(false, alucinacion.estoyMuerto());
	}

}
