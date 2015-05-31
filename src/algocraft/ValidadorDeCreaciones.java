package algocraft;

public class ValidadorDeCreaciones {
	
	protected int mineral;
	protected int gas;
	protected Creable creable;
	
	public ValidadorDeCreaciones( int mineralRequerido, int gasRequerido, Creable creableAGuardar ){
		mineral = mineralRequerido;
		gas = gasRequerido;
		creable = creableAGuardar;
	}
	
	public String getNombreCreable(){
		return creable.getNombre();
	}
	
	public boolean puedoCrearme( int mineralDisponible, int gasDisponible ){
		return ((mineralDisponible >= mineral) && (gasDisponible >= gas));
	}
}
