package modelo.unidades;

import java.util.Collection;

import modelo.Interfaces.Movible;
import modelo.ataques.Danio;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import modelo.movimientos.Movimiento;
import modelo.propiedad.Propiedad;
import modelo.stats.Movimientos;
import modelo.stats.Stat;

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
		if(this.estoyMuerto()){
			return false;
		}
		return movimiento.validarPaso(terrenoDestino);
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
	
	public Coordenada mover(Collection<Terreno> camino) throws PropiedadNoExisteEnEstaUbicacion, DestinoInvalidoException{
		return this.movimiento.ejecutar(camino, this);
	}
	
	@Override
	public void quitarEnergia() {
		this.vitalidad.quitarEnergia();
		
	}	
}
