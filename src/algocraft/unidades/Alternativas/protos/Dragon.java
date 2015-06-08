package algocraft.unidades.Alternativas.protos;


import algocraft.unidades.Alternativas.Unidad;

public class Dragon extends Unidad {
	
	public Dragon(){
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.DRAGON;
	}

	@Override
	protected void setearVida() {
		this.vida.set(100);
	}
}
