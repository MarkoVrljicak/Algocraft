package algocraft.mapa;

public abstract class Terreno {

		abstract public boolean sePuedeCaminar();
		//Para que las unidades a pie pregunten si pueden transitar por el casillero.
		
		abstract public boolean sePuedeVolar();
		//Para que las unidades voladoras pregunten si pueden navegar por el casillero.
		
		abstract public boolean sePuedeMinar();
		//Para que los centros y nexos de minerales pregunten si pueden ser construidos.
		
		abstract public boolean tieneGas();
		//Para que las refinerias y asimiladores sepan si pueden ser construidos.
		
		abstract public boolean sePuedeEdificar();
		//Para que los edificios que no sean recolectores de recursos sepan si pueden ser construidos.
		
		
		
}
