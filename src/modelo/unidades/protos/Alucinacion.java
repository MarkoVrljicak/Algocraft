package modelo.unidades.protos;

import modelo.ataques.Danio;
import modelo.movimientos.MovimientoAereo;
import modelo.movimientos.MovimientoTerrestre;
import modelo.stats.Escudo;
import modelo.stats.Movimientos;
import modelo.stats.Stat;
import modelo.stats.Vida;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;

public class Alucinacion extends UnidadAtacante{
	
	private Unidad otraUnidad;
	
	public Alucinacion(Unidad otraUnidad){
		this.otraUnidad = otraUnidad;
		super.inicializar();
		
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.ALUCINACION;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(0);
		this.vitalidad = new Escudo(this.otraUnidad.getVitalidadMaxima(), vida);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = this.otraUnidad.getPesoTransporte();
		
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 0;
	}


	@Override
	protected void setearDanio() {
		this.danio = new Danio(0,0,0,0);
		
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(otraUnidad.getMovimientos());
	}
	
	@Override
	public int getVida() {
		return ((Escudo)this.vitalidad).actualProtegida();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 0;
		
	}

	@Override
	protected void setearMovimiento() {
		if(this.otraUnidad.soyVolador()){
			this.movimiento = new MovimientoAereo();
		} else {
			this.movimiento = new MovimientoTerrestre();
		}
		
	}	
	
	public Unidad getUnidad(){
		return this.otraUnidad;
	}
	
}

