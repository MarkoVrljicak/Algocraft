package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.EdificioConEscudo;
import algocraft.construcciones.protos.EnumEdificiosProtos;

public class EdificioConEscudoTest {

	private static final EnumEdificiosProtos nombrePilon= EnumEdificiosProtos.PILON;
	private static final int vidaPilon = 300;
	private static final int escudoPilon = 300;
	private static final int tiempoConstruccionPilon = 5;

	@Test
	public void testCreoPilonControloSuVida(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		assertEquals(vidaPilon,pilon.getVida());
	}
	
	@Test
	public void testCreoPilonControloSuEscudo(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		assertEquals(escudoPilon,pilon.getEscudo());
	}
	
	@Test
	public void testCreoPilonControloNombre(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		assertEquals(nombrePilon,pilon.getNombre());
	}
	
	@Test
	public void testCreoPilonVeoQueEsteEnConstruccion(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		assertEquals(true,pilon.enConstruccion());
	}
	
	@Test
	public void testCreoPilonPasoTurnoVeoQueEsteEnConstruccion(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		pilon.iniciarTurno();
		
		assertEquals(true,pilon.enConstruccion());
	}
	
	@Test
	public void testCreoPilonEsperoSeConstruyaYVeoQueNoEsteEnConstruccion(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		for(int turno=1;turno<=tiempoConstruccionPilon; turno++)
			pilon.iniciarTurno();
		
		assertEquals(false,pilon.enConstruccion());
	}
	
	@Test
	public void testCreoPilonEsperoMuchoVeoQueNoEsteEnConstruccion(){
		EdificioConEscudo pilon= new EdificioConEscudo(nombrePilon,vidaPilon,tiempoConstruccionPilon,escudoPilon);
		
		for(int turno=1;turno<=100; turno++)
			pilon.iniciarTurno();
		
		assertEquals(false,pilon.enConstruccion());
	}
}

