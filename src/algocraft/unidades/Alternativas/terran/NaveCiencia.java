package algocraft.unidades.Alternativas.terran;

import algocraft.unidades.Alternativas.Unidad;



public class NaveCiencia extends Unidad{

	public NaveCiencia() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.NAVE_CIENCIA;
	}

	@Override
	protected void setearVida() {
		this.vida.set(200);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;		
	}

	@Override
	protected void setearAtaque() {
		// TODO Auto-generated method stub
		
	}


}
