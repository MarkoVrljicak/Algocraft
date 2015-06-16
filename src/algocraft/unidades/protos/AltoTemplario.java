package algocraft.unidades.protos;

import java.util.Collection;
import java.util.Iterator;

import algocraft.exception.DestinoInvalidoException;
import algocraft.magias.TormentaPsionica;
import algocraft.mapa.terrenos.Terreno;
import algocraft.movimientos.MovimientoTerrestre;
import algocraft.stats.Escudo;
import algocraft.stats.Magia;
import algocraft.stats.Movimientos;
import algocraft.stats.Stat;
import algocraft.stats.Vida;
import algocraft.unidades.Unidad;
import algocraft.unidades.UnidadMagica;

public class AltoTemplario extends UnidadMagica {
	
	TormentaPsionica tormentaPsionica;
	
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
	
	public void alucinacion(Unidad unidadAClonar, Collection<Terreno> zonaDeClonacion){
		int magiaRequerida = 100;
		if(this.magia.actual() < magiaRequerida){
			return;
		}
		
		int alucinaciones = 2;
		Terreno terrenoCualquiera;
		
		Iterator<Terreno> iter = zonaDeClonacion.iterator();
		while(iter.hasNext() && alucinaciones > 0){
			terrenoCualquiera = iter.next();
			try {
				terrenoCualquiera.almacenar(new Alucinacion(unidadAClonar));
			} catch (DestinoInvalidoException e) {
				continue;
			}
			alucinaciones--;
		}
		
		this.magia.disminuir(magiaRequerida);
		
	}

	public void tormentaPsionica(Collection<Terreno> area) {
		this.tormentaPsionica = new TormentaPsionica(area);
		this.tormentaPsionica.ejecutar();
	}
	
}
