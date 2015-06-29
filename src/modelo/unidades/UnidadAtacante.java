package modelo.unidades;

import modelo.Interfaces.Daniable;
import modelo.ataques.AtaqueNormal;
import modelo.ataques.Ataques;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.jugador.Colores;

abstract public class UnidadAtacante extends Unidad{
	
	private boolean yaAtaco;
	
	protected void inicializar() {
		super.inicializar();
		this.setearDanio();
		this.yaAtaco = false;
	}
	
	abstract protected void setearDanio();
	
	public boolean atacar(Daniable daniableAtacado, int distancia) {
		Ataques tipoAtaque = daniableAtacado.comoAtacarme();
		AtaqueNormal ataque = null;
		
		if(!(daniableAtacado.getColor()== Colores.GRIS) && daniableAtacado.getColor()== this.getColor())
			return false;
		
		if(this.yaAtaco || this.estoyMuerto())
			return false;
		
		if (tipoAtaque == Ataques.ATAQUE_NORMAL_AEREO){
			ataque = new AtaqueNormal(danio.getDanioAereo(), danio.getRangoAereo());
		} else if (tipoAtaque == Ataques.ATAQUE_NORMAL_TERRESTRE){
			ataque = new AtaqueNormal(danio.getDanioTerrestre(), danio.getRangoTerrestre());
		}
		this.yaAtaco = true;
		return ataque.ejecutarAtaque(daniableAtacado, distancia);
	}
	
	public void iniciarTurno() throws PropiedadNoEstaEnJuegoException{
		super.iniciarTurno();
		
		this.yaAtaco = false;
	}
}
