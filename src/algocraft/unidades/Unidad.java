package algocraft.unidades;

import java.util.Collection;

import algocraft.Interfaces.Movible;
import algocraft.ataques.Danio;
import algocraft.jugador.Colores;
import algocraft.mapa.Coordenada;
import algocraft.mapa.terrenos.Terreno;
import algocraft.movimientos.Movimiento;
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
	protected Movimiento movimiento;
	private Colores color = Colores.GRIS;

	//Template method
	protected void inicializar() {
		this.setearVida();
		this.setearNombre();
		this.setearPesoTransporte();
		this.seteartiempoDeConstruccion();
		this.setearSuministros();
		this.setearMovimientos();
		this.setearMovimiento();
	}

	abstract protected void setearSuministros();
	abstract protected void setearPesoTransporte();
	abstract protected void seteartiempoDeConstruccion();
	abstract protected void setearNombre();
	abstract protected void setearVida();
	abstract protected void setearMovimientos();
	abstract protected void setearMovimiento();
	
	public Unidades getNombre(){
		return nombre;
	}
	
	abstract public int getVida();
	public int getVitalidadMaxima(){
		return this.vitalidad.max();
	}
	
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
		if(!this.enConstruccion())
			this.vitalidad.regenerar();
	}


	public int getSuministros() {
		return this.suministros;
	}
	
	public int getMovimientos(){
		return this.movimientos.actual();
	}
	
	public int getPesoTransporte(){
		return this.pesoTransporte;
	}
	
	public void setColor(Colores color){
		this.color= color;
	}
	
	public Colores getColor(){
		return this.color;
	}
	
	public void darPaso(){
		int unPaso = 1;
		if(this.movimientos.actual() > 0)
			this.movimientos.disminuir(unPaso);
	}

	
	public boolean estoyMuerto(){
		return this.vitalidad.estoyVacio();
	}

	public void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	public boolean enConstruccion() {
		return (tiempoDeConstruccion!=0);
	}
	
	public Coordenada mover(Collection<Terreno> camino){
		return this.movimiento.ejecutar(camino, this);
	}
}
