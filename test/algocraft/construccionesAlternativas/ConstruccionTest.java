package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;

import org.junit.Test;

import construccionesAlternativas.Construccion;
import construccionesAlternativas.Edificio;

public class ConstruccionTest {
	
	private final Edificio nombreDeposito= Edificio.DEPOSITO_DE_SUMINISTROS;
	private final int vidaDeposito=500;
	private final int tiempoConstruccionDeposito= 6;

	@Test
	public void testCreoDepositoControloSuVida(){
		Construccion depositoSuministros= new Construccion(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		assertEquals(vidaDeposito,depositoSuministros.getVida());
	}
	
	@Test
	public void testCreoDepositoControloNombre(){
		Construccion depositoSuministros= new Construccion(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		assertEquals(nombreDeposito,depositoSuministros.getNombre());
	}
	
	@Test
	public void testCreoDepositoVeoQueEsteEnConstruccion(){
		Construccion depositoSuministros= new Construccion(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		assertEquals(true,depositoSuministros.enConstruccion());
	}
	
	@Test
	public void testCreoDepositoPasoTurnoVeoQueEsteEnConstruccion(){
		Construccion depositoSuministros= new Construccion(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		depositoSuministros.pasarTurno();
		
		assertEquals(true,depositoSuministros.enConstruccion());
	}
	
	@Test
	public void testCreoDepositoEsperoSeConstruyaYVeoQueNoEsteEnConstruccion(){
		Construccion depositoSuministros= new Construccion(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		for(int turno=1;turno<=tiempoConstruccionDeposito; turno++)
			depositoSuministros.pasarTurno();
		
		assertEquals(false,depositoSuministros.enConstruccion());
	}
	
	@Test
	public void testCreoDepositoEsperoMuchoVeoQueNoEsteEnConstruccion(){
		Construccion depositoSuministros= new Construccion(nombreDeposito,vidaDeposito,tiempoConstruccionDeposito);
		
		for(int turno=1;turno<=100; turno++)
			depositoSuministros.pasarTurno();
		
		assertEquals(false,depositoSuministros.enConstruccion());
	}
}
