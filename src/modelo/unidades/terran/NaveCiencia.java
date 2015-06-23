package modelo.unidades.terran;

import java.util.Collection;

import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.magias.AtaqueMagico;
import modelo.magias.EMP;
import modelo.magias.Radiacion;
import modelo.mapa.Coordenada;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.movimientos.MovimientoAereo;
import modelo.stats.Magia;
import modelo.stats.Movimientos;
import modelo.stats.Vida;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadMagica;



public class NaveCiencia extends UnidadMagica{
	

	public NaveCiencia() {
		super.inicializar();
	}

	
	@Override
	protected void setearNombre() {
		this.nombre = UnidadesTerran.NAVE_CIENCIA;
	}

	@Override
	protected void setearVida() {
		this.vitalidad = new Vida(200);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 0;		
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 2;
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(5);
	}

	@Override
	public int getVida() {
		return vitalidad.actual();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 10;
	}	
	
	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoAereo();
		
	}
	
	@Override
	protected void setearMagia(){
		int maximo = 200;
		int regeneracion = 10;
		this.magia = new Magia(maximo, regeneracion);
		this.magia.disminuir(150);
	}

	public void radiacion(Unidad unidad, Mapa mapa) throws PropiedadNoEstaEnJuegoException {
		int costo = 75;
		if(!chequearCostoDeMagia(costo)) return;
		
		AtaqueMagico radiacion = new Radiacion(unidad, mapa);
		radiacion.ejecutar();
		this.magias.add(radiacion);
		
	}
	
	public void emp(Mapa mapa, Coordenada objetivo) throws PropiedadNoEstaEnJuegoException{
		int costo = 100;
		if(!chequearCostoDeMagia(costo)) return;
		
		Collection<Terreno> campo = mapa.obtenerRadioDeCasilleros(2, objetivo);
		
		AtaqueMagico emp = new EMP(campo);
		emp.ejecutar();
		this.magias.add(emp);
	}
	
	private boolean chequearCostoDeMagia(int costo){
		if(this.magia.actual() < costo){
			return false;
		} else {
			this.magia.disminuir(costo);
			return true;
		}
	}
}
