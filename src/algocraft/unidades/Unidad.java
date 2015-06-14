package algocraft.unidades;

import algocraft.Interfaces.Daniable;
import algocraft.Interfaces.Movible;
import algocraft.ataques.AtaqueNormal;
import algocraft.ataques.Ataques;
import algocraft.ataques.Danio;
import algocraft.mapa.terrenos.Terreno;
import algocraft.propiedad.Propiedad;
import algocraft.stats.Movimientos;
import algocraft.stats.Stat;

public abstract class Unidad extends Propiedad implements Movible{
	
	protected Unidades nombre;
	protected Stat vitalidad;
	protected int pesoTransporte;
	protected int tiempoDeConstruccion;
	protected int suministros;
	protected Danio danio;
	protected Movimientos movimientos;

	//Template method
	protected void inicializar() {
		this.setearVida();
		this.setearNombre();
		this.setearPesoTransporte();
		this.seteartiempoDeConstruccion();
		this.setearSuministros();
		this.setearDanio();
		this.setearMovimientos();
	}

	abstract protected void setearDanio();
	abstract protected void setearSuministros();
	abstract protected void setearPesoTransporte();
	abstract protected void seteartiempoDeConstruccion();
	abstract protected void setearNombre();
	abstract protected void setearVida();
	abstract protected void setearMovimientos();
	
	public Unidades getNombre(){
		return nombre;
	}
	
	abstract public int getVida();
	
	public boolean soyVolador(){
		return (pesoTransporte == 0);
	}
	
	//los que tengan escudo deberian pisarlo
	public void recibirDanio(int cantidadDanio){
		vitalidad.disminuir(cantidadDanio);
	}
	
	@Override
	public boolean puedoMoverme(Terreno terrenoDestino) {
		if (this.soyVolador()){
			return terrenoDestino.sePuedeVolar();
		} else {
			return terrenoDestino.sePuedeCaminar();
		}
	}
	
	@Override
	public void iniciarTurno() {
		this.disminuirTiempoDeConstruccion();
		this.vitalidad.regenerar();
	}


	public boolean atacar(Daniable daniableAtacado, int distancia) {
		Ataques tipoAtaque = daniableAtacado.comoAtacarme();
		AtaqueNormal ataque = null;
		
		if (tipoAtaque == Ataques.ATAQUE_NORMAL_AEREO){
			ataque = new AtaqueNormal(danio.getDanioAereo(), danio.getRangoAereo());
		} else if (tipoAtaque == Ataques.ATAQUE_NORMAL_TERRESTRE){
			ataque = new AtaqueNormal(danio.getDanioTerrestre(), danio.getRangoTerrestre());
		}
		
		return ataque.ejecutarAtaque(daniableAtacado, distancia);
	}


	public int getSuministros() {
		return this.suministros;
	}
	
	public int getMovimientos(){
		return this.movimientos.actual();
	}
	
	public void darPaso(){
		int unPaso = 1;
		if(this.movimientos.actual() > 0)
			this.movimientos.disminuir(unPaso);
	}

	
	public boolean estoyMuerto(){
		return this.vitalidad.estoyVacio();
	}

	protected void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	public boolean enConstruccion() {
		return (tiempoDeConstruccion!=0);
	}
}
