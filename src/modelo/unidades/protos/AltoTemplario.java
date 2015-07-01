package modelo.unidades.protos;

import java.util.Collection;
import java.util.Iterator;

import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.magias.AtaqueMagico;
import modelo.magias.TormentaPsionica;
import modelo.mapa.Coordenada;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.movimientos.MovimientoTerrestre;
import modelo.stats.Escudo;
import modelo.stats.Magia;
import modelo.stats.Movimientos;
import modelo.stats.Stat;
import modelo.stats.Vida;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadMagica;

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
	public int getVidaMaxima() {
		return ((Escudo)this.vitalidad).maxProtegida();
	}

	@Override
	public int getEscudo() {
		return ((Escudo)this.vitalidad).actual();
	}

	@Override
	public int getEscudoMaximo() {
		return ((Escudo)this.vitalidad).max();
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
	
	public void alucinacion(Unidad unidadAClonar, Mapa mapa, Coordenada objetivo ){
		Collection<Terreno> zonaDeClonacion = mapa.obtenerRadioDeCasilleros(2, objetivo);
		
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
				mapa.almacenar(new Alucinacion(unidadAClonar), terrenoCualquiera.getCoordenada());
			} catch (DestinoInvalidoException | FueraDeLimitesException e) {
				continue;
			}
			alucinaciones--;
		}
		
		this.magia.disminuir(magiaRequerida);
		
	}

	public void tormentaPsionica(Mapa mapa, Coordenada coordenadaObjetivo) throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion {
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, coordenadaObjetivo);
		if(this.magia.actual() < 75){
			return;
		} else {
			this.magia.disminuir(75);
		}
		
		AtaqueMagico tormenta = new TormentaPsionica(area);
		tormenta.ejecutar();
		this.magias.add(tormenta);
		
		mapa.limpiarMuertos();
	}

	
	
}
