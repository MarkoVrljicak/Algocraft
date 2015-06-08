package algocraft.unidades.Alternativas.terran;

import algocraft.ataques.AtaqueNormal;
import algocraft.unidades.Alternativas.Unidad;



public class Marine extends Unidad{

	public Marine() {
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.MARINE;
	}

	@Override
	protected void setearVida() {
		this.vida.set(40);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 1;
	}

	@Override
	protected void setearAtaque() {
		this.ataque = new AtaqueNormal(6,6,4);
		
	}


}
