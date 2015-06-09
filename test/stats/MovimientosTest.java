package stats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovimientosTest {

	@Test
	public void MovimientosSeRegeneraPorCompleto() {
		final int movimientosMaximos = 7;
		Movimientos movimientos = new Movimientos();
		movimientos.set(movimientosMaximos);
		movimientos.disminuir(movimientosMaximos);
		
		movimientos.regenerar();
		
		assertEquals(movimientosMaximos,movimientos.actual());
	}
	
	@Test
	public void MovimientosRegeneraDosVecesNoSuperaElMaximo() {
		final int movimientosMaximos = 7;
		Movimientos movimientos = new Movimientos();
		movimientos.set(movimientosMaximos);
		movimientos.disminuir(movimientosMaximos);
		
		movimientos.regenerar();
		movimientos.regenerar();
		
		assertEquals(movimientosMaximos,movimientos.actual());
	}
}
