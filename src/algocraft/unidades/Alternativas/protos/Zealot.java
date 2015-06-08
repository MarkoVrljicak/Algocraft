package algocraft.unidades.Alternativas.protos;


import algocraft.unidades.Alternativas.Unidad;

public class Zealot extends Unidad{

	public Zealot() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.ZEALOT;
	}

	@Override
	protected void setearVida() {
		this.vida.set(100);
	}

	@Override
	protected boolean soyVolador() {
		return false;
	}
}
