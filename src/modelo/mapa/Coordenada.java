package modelo.mapa;

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
		if(otroObjeto==null) return false;
		Coordenada otraCoordenada;
		try{
			otraCoordenada = (Coordenada) otroObjeto;
		}catch(ClassCastException e){
			return false;
		}
		int otroX = otraCoordenada.getX();
		int otroY = otraCoordenada.getY();
		
		boolean iguales= ( (x == otroX ) && (y == otroY ) );
		
		return iguales;
	}
	
	@Override
	public int hashCode() {
		int primo = 31;
		int resultado = 1;
		resultado = resultado*primo + x;
		resultado = resultado*primo + y;
		return resultado;
	}

	public int distanciaA(Coordenada otraCoordenada) {
		int otroX=otraCoordenada.getX();
		int otroY=otraCoordenada.getY();
		
		int desplazamientoHorizontal = Math.abs(x - otroX);
		int desplazamientoVertical = Math.abs(y - otroY);
		
		int distancia = Math.max(desplazamientoHorizontal, desplazamientoVertical);

		return distancia;
	}

	

}
