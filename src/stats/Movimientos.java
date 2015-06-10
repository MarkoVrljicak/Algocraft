package stats;

public class Movimientos extends Stat{

	public Movimientos(int maximoValor) {
		super(maximoValor);
	}

	@Override
	public void regenerar() {
		this.actualValor = this.maximoValor;
	}
}
