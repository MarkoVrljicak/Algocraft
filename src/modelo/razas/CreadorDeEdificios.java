package modelo.razas;

import java.util.HashMap;
import java.util.Set;

import modelo.construcciones.Construccion;
import modelo.construcciones.EnumEdificios;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.EdificiosAbstractFactory;
import modelo.jugador.Jugador;

public abstract class CreadorDeEdificios {

	protected EnumRazas nombre;
	protected HashMap<EnumEdificios, EdificiosAbstractFactory> construccionesCreables;
	protected Jugador duenio;
	
	//metodos de inicializacion
	protected CreadorDeEdificios(){
		construccionesCreables = new HashMap<EnumEdificios, EdificiosAbstractFactory>();
		this.determinarCreables();
	}
	
	abstract protected void determinarCreables();
	
	protected void aniadirEdificioCreable(EnumEdificios nombreEdificio, EdificiosAbstractFactory creador){
		this.construccionesCreables.put(nombreEdificio, creador);
	}
	
	//accessors
	
	public EnumRazas getNombre(){
		return nombre;
	}
	
	public void setDuenio(Jugador jugador) {
		duenio = jugador;		
	}
	
	public Set<EnumEdificios> getListaDeConstrucciones(){
		return construccionesCreables.keySet();
	}
	
	public boolean tengoConstruccion(EnumEdificios nombreEdificio){
		return construccionesCreables.containsKey(nombreEdificio);
	}
	
	public Construccion crearConstruccion(EnumEdificios nombreEdificio) 
			throws MineralInsuficienteException,GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException{
		EdificiosAbstractFactory creador = construccionesCreables.get(nombreEdificio);
		
		if(!tengoMineralSuficiente(creador))
			throw new MineralInsuficienteException();
		if(!tengoGasSuficiente(creador))
			throw new GasInsuficienteException();
		if(!tengoDependencias(creador))
			throw new DependenciasNoCumplidasException();

		duenio.consumirMineral(creador.getMineralNecesario());
		duenio.consumirGas(creador.getGasNecesario());

		Construccion edificio = creador.crearEdificio();
		edificio.setDuenio(duenio);
		return edificio;
	}
	
	
	private boolean tengoDependencias(EdificiosAbstractFactory creador) {
		if(creador.necesitoConstruccionAnterior())
			return (duenio.tieneConstruccion(creador.getConstruccionNecesitada()));
		else
			return true;
	}

	private boolean tengoGasSuficiente(EdificiosAbstractFactory creador) {
		int gasDisponible = this.duenio.getGas();
		return (gasDisponible >= creador.getGasNecesario());
	}

	private boolean tengoMineralSuficiente(EdificiosAbstractFactory creador) {
		int mineralDisponible = this.duenio.getMineral();
		return(mineralDisponible >= creador.getMineralNecesario());
	}

	public boolean puedoCrearConstruccion(EdificiosAbstractFactory creador) {
		return (this.tengoGasSuficiente(creador)&& 
				this.tengoMineralSuficiente(creador)&&
				this.tengoDependencias(creador));
	}

	public boolean puedoCrearConstruccion(EnumEdificios nombreEdificio) {
		 return puedoCrearConstruccion(construccionesCreables.get(nombreEdificio));
		
	}		
}
