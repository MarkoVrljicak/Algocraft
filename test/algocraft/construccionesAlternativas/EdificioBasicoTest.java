package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdificioBasicoTest {
	
	private final Edificios nombreDeposito= Edificios.DEPOSITO_DE_SUMINISTROS;
	private final int vidaDeposito=500;
	private final int tiempoConstruccionDeposito= 6;

	@Test
	public void testCreoDepositoControloSuVida(){
		EdificioBasico depositoSuministros= new EdificioBasico(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		assertEquals(vidaDeposito,depositoSuministros.getVida());
	}
	
	@Test
	public void testCreoDepositoControloNombre(){
		EdificioBasico depositoSuministros= new EdificioBasico(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		assertEquals(nombreDeposito,depositoSuministros.getNombre());
	}
	
	@Test
	public void testCreoDepositoVeoQueEsteEnConstruccion(){
		EdificioBasico depositoSuministros= new EdificioBasico(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		assertEquals(true,depositoSuministros.enConstruccion());
	}
	
	@Test
	public void testCreoDepositoPasoTurnoVeoQueEsteEnConstruccion(){
		EdificioBasico depositoSuministros= new EdificioBasico(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		depositoSuministros.pasarTurno();
		
		assertEquals(true,depositoSuministros.enConstruccion());
	}
	
	@Test
	public void testCreoDepositoEsperoSeConstruyaYVeoQueNoEsteEnConstruccion(){
		EdificioBasico depositoSuministros= new EdificioBasico(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		for(int turno=1;turno<=tiempoConstruccionDeposito; turno++)
			depositoSuministros.pasarTurno();
		
		assertEquals(false,depositoSuministros.enConstruccion());
	}
	
	@Test
	public void testCreoDepositoEsperoMuchoVeoQueNoEsteEnConstruccion(){
		EdificioBasico depositoSuministros= new EdificioBasico(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		for(int turno=1;turno<=100; turno++)
			depositoSuministros.pasarTurno();
		
		assertEquals(false,depositoSuministros.enConstruccion());
	}
}
