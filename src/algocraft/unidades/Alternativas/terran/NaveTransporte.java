package algocraft.unidades.Alternativas.terran;

import algocraft.unidades.Alternativas.Unidad;



public class NaveTransporte extends Unidad{

	public NaveTransporte() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.NAVE_TRANSPORTE;
	}

	@Override
	protected void setearVida() {
		this.vida.set(150);
	}

	@Override
	protected boolean soyVolador() {
		return true;
	}
}
