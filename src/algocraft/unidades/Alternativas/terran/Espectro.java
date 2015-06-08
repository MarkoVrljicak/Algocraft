package algocraft.unidades.Alternativas.terran;

import algocraft.unidades.Alternativas.Unidad;


public class Espectro extends Unidad{

	public Espectro() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.ESPECTRO;
	}

	@Override
	protected void setearVida() {
		this.vida.set(120);
	}

	@Override
	protected boolean soyVolador() {
		return true;
	}
}
