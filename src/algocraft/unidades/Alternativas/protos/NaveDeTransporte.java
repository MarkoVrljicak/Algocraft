package algocraft.unidades.Alternativas.protos;

import algocraft.unidades.Alternativas.Unidad;


public class NaveDeTransporte extends Unidad {

	public NaveDeTransporte() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.NAVE_DE_TRANSPORTE;
	}

	@Override
	protected void setearVida() {
		this.vida.set(150);
	}
}
