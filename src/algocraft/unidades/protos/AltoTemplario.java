package algocraft.unidades.protos;

import algocraft.movimientos.MovimientoTerrestre;
import algocraft.stats.Escudo;
import algocraft.stats.Magia;
import algocraft.stats.Movimientos;
import algocraft.stats.Stat;
import algocraft.stats.Vida;
import algocraft.unidades.UnidadMagica;



public class AltoTemplario extends UnidadMagica {
	
	public AltoTemplario(){
		super.inicializar();
	}

	@Override
	protected void setearNombre() {
		this.nombre = UnidadesProtos.ALTO_TEMPLARIO;
	}

	@Override
	protected void setearVida() {
		Stat vida = new Vida(40);
		this.vitalidad = new Escudo(40, vida);
	}

	@Override
	protected void setearPesoTransporte() {
		this.pesoTransporte = 2;
		
	}
	
	@Override
	protected void setearSuministros() {
		this.suministros = 2;
	}

	@Override
	protected void setearMovimientos() {
		this.movimientos = new Movimientos(3);
	}
	
	@Override
	public int getVida() {
		return ((Escudo)this.vitalidad).actualProtegida();
	}

	@Override
	protected void seteartiempoDeConstruccion() {
		this.tiempoDeConstruccion = 7;
	}

	@Override
	protected void setearMovimiento() {
		this.movimiento = new MovimientoTerrestre();
		
	}

	@Override
	protected void setearMagia(){
		int maximo = 200;
		int regeneracion = 15;
		this.magia = new Magia(maximo, regeneracion);
		this.magia.disminuir(150);
	}
	
}
