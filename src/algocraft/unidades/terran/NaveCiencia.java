package algocraft.unidades.terran;

import java.util.Collection;

import algocraft.magias.AtaqueMagico;
import algocraft.magias.EMP;
import algocraft.magias.Radiacion;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.movimientos.MovimientoAereo;
import algocraft.stats.Magia;
import algocraft.stats.Movimientos;
import algocraft.stats.Vida;
import algocraft.unidades.Unidad;
import algocraft.unidades.UnidadMagica;



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

	public void radiacion(Unidad unidad, Mapa mapa) {
		int costo = 75;
		if(!chequearCostoDeMagia(costo)) return;
		
		AtaqueMagico radiacion = new Radiacion(unidad, mapa);
		radiacion.ejecutar();
		this.magias.add(radiacion);
		
	}
	
	public void emp(Mapa mapa, Coordenada objetivo){
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
