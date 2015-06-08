package algocraft.unidades.Alternativas.terran;


import algocraft.unidades.Alternativas.Unidad;

public class Golliat extends Unidad{

	public Golliat() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.GOLLIAT;
	}

	@Override
	protected void setearVida() {
		this.vida.set(125);
	}

	@Override
	protected boolean soyVolador() {
		return false;
	}
}
