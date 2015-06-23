package visual.dibujadores;

import java.util.HashMap;

import javax.swing.JLabel;

import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;


public class DibujadorTerreno {
	
	
	private HashMap<Terrenos, Dibujador> dibujadores;
	
	public DibujadorTerreno(){
		
		dibujadores = new HashMap<Terrenos , Dibujador>();
		//terrenos
		dibujadores.put(Terrenos.TIERRA,new DibujadorTierra());
		dibujadores.put(Terrenos.AIRE,new DibujadorAire());
		dibujadores.put(Terrenos.MINERALES,new DibujadorMineral());
		dibujadores.put(Terrenos.VOLCAN,new DibujadorVolcan());		
	}
	
	public JLabel dibujar(Terreno unTerreno){
		Dibujador unDibujador;
		
		if(! (unTerreno == null))
			unDibujador= dibujadores.get(unTerreno.getNombre());
		else
			unDibujador = new DibujadorVacio();
		
		return unDibujador.dibujar();
		
	}

}
