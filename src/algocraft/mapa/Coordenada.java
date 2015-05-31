package algocraft.mapa;

public class Coordenada {

	private int x;
	private int y;
	

	public Coordenada(int i, int j) {
		x = i;
		y = j;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object otroObjeto) {
		
		if ( (otroObjeto == null) || ! (otroObjeto instanceof Coordenada) ){
			return false;};
		
		Coordenada otraCoordenada = (Coordenada) otroObjeto;
		int otroX = otraCoordenada.getX();
		int otroY = otraCoordenada.getY();
		
		boolean iguales= ( (x == otroX ) && (y == otroY ) );
		
		return iguales;
	}
	
	@Override
	public int hashCode() {
		return (x + y * 1000);
	}

	public int distanciaA(Coordenada otraCoordenada) {
		int otroX=otraCoordenada.getX();
		int otroY=otraCoordenada.getY();
		
		int distancia = Math.abs(x - otroX )
				+ Math.abs(y - otroY);

		return distancia;
	}

	

}
