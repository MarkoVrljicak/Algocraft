package algocraft.mapa;

public class Coordenada {

	public int x;
	public int y;

	public Coordenada(int i,int j) {
		x= i;
		y= j;
	}
	
	
	@Override
	public boolean equals(Object otroObjeto){
		
		if(otroObjeto==null || !(otroObjeto instanceof Coordenada)) return false;
		Coordenada otraCoordenada= (Coordenada) otroObjeto;
		return ( ( x == otraCoordenada.x) && (y == otraCoordenada.y) ) ;
	}

	@Override
	public int hashCode() {
		return ( x +  y*1000  ) ;
	}


	public int distanciaA(Coordenada otraCoordenada) {
		int distancia=Math.abs( x-otraCoordenada.x ) + Math.abs( y-otraCoordenada.y );
		return distancia;
	}
	

}

