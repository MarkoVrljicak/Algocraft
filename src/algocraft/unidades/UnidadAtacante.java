package algocraft.unidades;

import algocraft.Interfaces.Daniable;
import algocraft.ataques.AtaqueNormal;
import algocraft.ataques.Ataques;
import algocraft.jugador.Colores;

abstract public class UnidadAtacante extends Unidad{
	
	protected void inicializar() {
		super.inicializar();
		this.setearDanio();
	}
	
	abstract protected void setearDanio();
	
	public boolean atacar(Daniable daniableAtacado, int distancia) {
		Ataques tipoAtaque = daniableAtacado.comoAtacarme();
		AtaqueNormal ataque = null;
		
		if(!(daniableAtacado.getColor()== Colores.GRIS) && daniableAtacado.getColor()== this.getColor())
			return false;
		
		if (tipoAtaque == Ataques.ATAQUE_NORMAL_AEREO){
			ataque = new AtaqueNormal(danio.getDanioAereo(), danio.getRangoAereo());
		} else if (tipoAtaque == Ataques.ATAQUE_NORMAL_TERRESTRE){
			ataque = new AtaqueNormal(danio.getDanioTerrestre(), danio.getRangoTerrestre());
		}
		
		return ataque.ejecutarAtaque(daniableAtacado, distancia);
	}
}
