package razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import razasAlternativas.Protoss;

public class ProtossTest {

	private static final EnumEdificiosProtos nombreAcceso= EnumEdificiosProtos.ACCESO;
	private static final EnumEdificiosProtos nombreArchivosTemplarios= EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS;
	private static final EnumEdificiosProtos nombreAsimilador= EnumEdificiosProtos.ASIMILADOR;
	private static final EnumEdificiosProtos nombreNexoMineral= EnumEdificiosProtos.NEXO_MINERAL;
	private static final EnumEdificiosProtos nombrePuertoEstelar= EnumEdificiosProtos.PUERTO_ESTELAR;
	private static final EnumEdificiosProtos nombrePilon= EnumEdificiosProtos.PILON;

	@Test
	public void testProtossInicializaConAcceso() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreAcceso));
	}
	
	@Test
	public void testProtossInicializaConArchivosTemplarios() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreArchivosTemplarios ));
	}
	
	@Test
	public void testProtossInicializaConAsimilador() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreAsimilador ));
	}
	
	@Test
	public void testProtossInicializaConNexoMineral() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreNexoMineral ));
	}
	
	@Test
	public void testProtossInicializaConPilon() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombrePilon ));
	}
	
	@Test
	public void testProtossInicializaConPuertoEstelar() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombrePuertoEstelar ));
	}
	/* se van a test de integracion
	@Test
	public void testProtossCreaAcceso() {
		Protoss protoss = new Protoss();
		Construccion acceso = protoss.crearConstruccion(nombreAcceso);
		
		assertEquals(nombreAcceso, acceso.getNombre());
	}
	
	@Test
	public void testProtossCreaAccesoSinRecursos() {
		Protoss protoss = new Protoss();
		Construccion acceso = protoss.crearConstruccion(nombreAcceso);
		
		assertEquals(null, acceso);
	}
	*/
	@Test
	public void testProtossEmpiezaConSieteConstruccionesDisponibles(){
		Protoss protoss = new Protoss();
		
		assertEquals(7, protoss.getListaDeConstrucciones().size());
	}
}
	
