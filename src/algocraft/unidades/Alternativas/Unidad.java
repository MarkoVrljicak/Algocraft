package algocraft.unidades.Alternativas;

import stats.Movimientos;
import stats.Stat;
import Interfaces.Actualizable;
import Interfaces.Daniable;
import Interfaces.Movible;
import algocraft.ataques.AtaqueNormal;
import algocraft.ataques.Ataques;
import algocraft.ataques.Danio;
import algocraft.mapa.terrenos.Terreno;

public abstract class Unidad implements Daniable, Movible, Actualizable{
	
	protected Unidades nombre;
	protected Stat stat;
	protected int pesoTransporte;
	protected int suministros;
	protected Danio danio;
	protected Movimientos movimientos;

	//Template method
	protected void inicializar() {
		this.setearVida();
		this.setearNombre();
		this.setearPesoTransporte();
		this.setearSuministros();
		this.setearDanio();
		this.setearMovimientos();
	}

	abstract protected void setearDanio();
	abstract protected void setearSuministros();
	abstract protected void setearPesoTransporte();
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
		stat.disminuir(cantidadDanio);
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
	public void pasarTurno() {
		// TODO Auto-generated method stub
		
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
	
	public Movimientos getMovimientos(){
		return this.movimientos;
	}
	
	public Ataques comoAtacarme(){
		boolean soyVolador = this.soyVolador();
		if(soyVolador){
			return Ataques.ATAQUE_NORMAL_AEREO;
		} else {
			return Ataques.ATAQUE_NORMAL_TERRESTRE;
		}
	}
	
	public boolean estoyMuerto(){
		return this.stat.estoyVacio();
	}

}
