package algocraft.ataques;

public class Danio {
	int danioAereo;
	int danioTerrestre;
	int rangoAereo;
	int rangoTerrestre;
	
	public Danio(int danioAire, int danioTierra, int rangoAire, int rangoTierra){
		danioAereo = danioAire;
		danioTerrestre = danioTierra;
		rangoAereo = rangoAire;
		rangoTerrestre = rangoTierra;
	}
	
	public int getDanioAereo(){
		return danioAereo;
	}
	public int getDanioTerrestre(){
		return danioTerrestre;
	}
	public int getRangoAereo(){
		return rangoAereo;
	}
	public int getRangoTerrestre(){
		return rangoTerrestre;
	}
}
