package algocraft.construccionesAlternativas.terran;

import stats.Recurso;
import algocraft.construccionesAlternativas.CreadorDeUnidades;
import algocraft.construccionesAlternativas.EdificioBasico;
import algocraft.construccionesAlternativas.EnumEdificiosTerran;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;
import algocraft.unidades.Alternativas.UnidadesTerran;

public class PuertoEstelar extends CreadorDeUnidades {
	
	private static final EnumEdificiosTerran nombrePuertoEstelar = EnumEdificiosTerran.PUERTO_ESTELAR;
	private static final UnidadesTerran nombreEspectro = UnidadesTerran.ESPECTRO;
	private static final UnidadesTerran nombreNaveDeTransporte = UnidadesTerran.NAVE_TRANSPORTE;
	private static final UnidadesTerran nombreNaveDeCiencia = UnidadesTerran.NAVE_CIENCIA;
	private static final int vidaEspectro = 40;
	private static final int vidaNaveDeTransporte = 40;
	private static final int vidaNaveDeCiencia = 40;
	private static final Recurso recursosNecesariosEspectro = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeCiencia = new Recurso(50,0);
	private static final int poblacionNecesariaEspectro = 1;
	private static final int poblacionNecesariaNaveDeTransporte = 1;
	private static final int poblacionNecesariaNaveDeCiencia = 1;

	public PuertoEstelar() {
		super(new EdificioBasico(nombrePuertoEstelar,1300,10));
	}
	
	@Override
	protected void determinarCreables() {
		this.unidadesCreables.add(nombreEspectro);
		this.unidadesCreables.add(nombreNaveDeTransporte);
		this.unidadesCreables.add(nombreNaveDeCiencia);
	}
	
	public Unidad crearUnidad(Unidades nombreUnidad){
		if(nombreUnidad==nombreEspectro)
			return this.crearUnidadEspecifica(nombreEspectro, vidaEspectro, recursosNecesariosEspectro, poblacionNecesariaEspectro);
		
		if(nombreUnidad==nombreNaveDeTransporte)
			return this.crearUnidadEspecifica(nombreNaveDeTransporte, vidaNaveDeTransporte, recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte);
		
		if(nombreUnidad==nombreNaveDeCiencia)
			return this.crearUnidadEspecifica(nombreNaveDeCiencia, vidaNaveDeCiencia, recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia);
		return null;//lanzar excepcion?
			
	}
	
	@Override
	public void pasarTurno() {
		this.edificio.pasarTurno();
	}	

}
