package modelo.construcciones;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.EdificioBasico;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;

import org.junit.Test;

public class EdificioBasicoTest {

	private static final int vidaDeposito = 500;
	private static final int tiempoConstruccionDeposito = 6;

	@Test
	public void testCreoDepositoControloSuVida() {
		EdificioBasico depositoSuministros = new EdificioBasico(
				EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, vidaDeposito,
				tiempoConstruccionDeposito);

		assertEquals(vidaDeposito, depositoSuministros.getVida());
	}

	@Test
	public void testCreoDepositoControloNombre() {
		EdificioBasico depositoSuministros = new EdificioBasico(
				EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, vidaDeposito,
				tiempoConstruccionDeposito);

		assertEquals(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS,
				depositoSuministros.getNombre());
	}

	@Test
	public void testCreoDepositoVeoQueEsteEnConstruccion() {
		EdificioBasico depositoSuministros = new EdificioBasico(
				EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, vidaDeposito,
				tiempoConstruccionDeposito);

		assertEquals(true, depositoSuministros.enConstruccion());
	}

	@Test
	public void testCreoDepositoPasoTurnoVeoQueEsteEnConstruccion() {
		EdificioBasico depositoSuministros = new EdificioBasico(
				EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, vidaDeposito,
				tiempoConstruccionDeposito);

		depositoSuministros.iniciarTurno();

		assertEquals(true, depositoSuministros.enConstruccion());
	}

	@Test
	public void testCreoDepositoEsperoSeConstruyaYVeoQueNoEsteEnConstruccion() {
		EdificioBasico depositoSuministros = new EdificioBasico(
				EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, vidaDeposito,
				tiempoConstruccionDeposito);

		for (int turno = 1; turno <= tiempoConstruccionDeposito; turno++)
			depositoSuministros.iniciarTurno();

		assertEquals(false, depositoSuministros.enConstruccion());
	}

	@Test
	public void testCreoDepositoEsperoMuchoVeoQueNoEsteEnConstruccion() {
		EdificioBasico depositoSuministros = new EdificioBasico(
				EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, vidaDeposito,
				tiempoConstruccionDeposito);

		for (int turno = 1; turno <= 100; turno++)
			depositoSuministros.iniciarTurno();

		assertEquals(false, depositoSuministros.enConstruccion());
	}
}
