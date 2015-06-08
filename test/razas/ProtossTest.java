//package razas;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import algocraft.construcciones.Construccion;
//import stats.Recurso;
//
//public class ProtossTest {
//
//	private Recurso sinRecursos = new Recurso(0,0);
//	private Recurso muchosRecursos = new Recurso(999,999);
//	private String nombreAcceso = "Acceso";
//	private String nombreArchivosTeamplarios = "Archivos Templarios";
//	private String nombreAsimilador = "Asimilador";
//	private String nombreNexoMineral = "Nexo Mineral";
//	private String nombrePilon = "Pilon";
//	private String nombrePuertoEstelar = "Puerto Estelar";
//
//	@Test
//	public void testProtossInicializaConAcceso() {
//		Protoss protoss = new Protoss();
//		
//		assertEquals(true, protoss.tengoConstruccion(nombreAcceso));
//	}
//	
//	@Test
//	public void testProtossInicializaConArchivosTemplarios() {
//		Protoss protoss = new Protoss();
//		
//		assertEquals(true, protoss.tengoConstruccion(nombreArchivosTeamplarios ));
//	}
//	
//	@Test
//	public void testProtossInicializaConAsimilador() {
//		Protoss protoss = new Protoss();
//		
//		assertEquals(true, protoss.tengoConstruccion(nombreAsimilador ));
//	}
//	
//	@Test
//	public void testProtossInicializaConNexoMineral() {
//		Protoss protoss = new Protoss();
//		
//		assertEquals(true, protoss.tengoConstruccion(nombreNexoMineral ));
//	}
//	
//	@Test
//	public void testProtossInicializaConPilon() {
//		Protoss protoss = new Protoss();
//		
//		assertEquals(true, protoss.tengoConstruccion(nombrePilon ));
//	}
//	
//	@Test
//	public void testProtossInicializaConPuertoEstelar() {
//		Protoss protoss = new Protoss();
//		
//		assertEquals(true, protoss.tengoConstruccion(nombrePuertoEstelar ));
//	}
//	
//	@Test
//	public void testProtossCreaAcceso() {
//		Protoss protoss = new Protoss();
//		Construccion acceso = protoss.construirConstruccion(muchosRecursos, nombreAcceso);
//		
//		assertEquals(nombreAcceso, acceso.getNombre());
//	}
//	
//	@Test
//	public void testProtossCreaAccesoSinRecursos() {
//		Protoss protoss = new Protoss();
//		Construccion acceso = protoss.construirConstruccion(sinRecursos, nombreAcceso);
//		
//		assertEquals(null, acceso);
//	}
//	
//	@Test
//	public void testProtossEmpiezaConSeisConstruccionesDisponibles(){
//		Protoss protoss = new Protoss();
//		
//		assertEquals(6, protoss.getListaDeConstrucciones().size());
//	}
//}
	
