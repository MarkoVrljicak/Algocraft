package visual.dibujadores;

import java.util.HashMap;

import javax.swing.JLabel;

import modelo.mapa.terrenos.Aire;
import modelo.mapa.terrenos.Minerales;
import modelo.mapa.terrenos.Tierra;
import modelo.mapa.terrenos.Volcan;

@SuppressWarnings("rawtypes")
public class DibujadorTerreno {
	
	
	private HashMap<Class,Dibujador> dibujadores;
	
	public DibujadorTerreno(){
		
		dibujadores = new HashMap<Class, Dibujador>();
		//terrenos
		dibujadores.put(Tierra.class,new DibujadorTierra());
		dibujadores.put(Aire.class,new DibujadorAire());
		dibujadores.put(Minerales.class,new DibujadorMineral());
		dibujadores.put(Volcan.class,new DibujadorVolcan());		
	}
	
	public JLabel dibujar(Object o){
		Dibujador unDibujador;
		if(! (o == null))
			unDibujador= dibujadores.getOrDefault(o.getClass(), new DibujadorVacio());
		else
			unDibujador = new DibujadorVacio();
		
		return unDibujador.dibujar();
		
	}

}
