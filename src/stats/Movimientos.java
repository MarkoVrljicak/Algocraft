package stats;

public class Movimientos extends Stat implements Regenerable {

	@Override
	public void regenerar() {
		this.actualValor = this.maximoValor;
	}
}
