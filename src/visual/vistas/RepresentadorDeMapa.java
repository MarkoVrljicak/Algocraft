package visual.vistas;

import java.util.HashMap;

import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;
import visual.dibujadores.DibujadorTerreno;
import visual.dibujadores.DibujadorTerrenoAire;
import visual.dibujadores.DibujadorTerrenoMinerales;
import visual.dibujadores.DibujadorTerrenoTierra;
import visual.dibujadores.DibujadorTerrenoVolcan;
import controlador.MiControladorMouse;


public class RepresentadorDeMapa {
	
	private static RepresentadorDeMapa instance = null;
	private HashMap<Terrenos, DibujadorTerreno> terrenos;
	
	public static RepresentadorDeMapa getInstance(){
		if(instance == null)
			instance = new RepresentadorDeMapa();
		
		return instance;
	}
	
	protected RepresentadorDeMapa(){
		
		terrenos = new HashMap<Terrenos , DibujadorTerreno>();
		//terrenos
		terrenos.put(Terrenos.TIERRA, new DibujadorTerrenoTierra());
		terrenos.put(Terrenos.AIRE, new DibujadorTerrenoAire());
		terrenos.put(Terrenos.MINERALES, new DibujadorTerrenoMinerales());
		terrenos.put(Terrenos.VOLCAN, new DibujadorTerrenoVolcan());		
	}
	
	public VistaTerreno dibujar(Terreno unTerreno){
		DibujadorTerreno dibujador = terrenos.get(unTerreno.getNombre());
		VistaTerreno vistaTerreno = new VistaTerreno(unTerreno, dibujador.getImagen(), dibujador.getEdificiosConstruibles());
		vistaTerreno.addMouseListener(new MiControladorMouse(vistaTerreno));
		return vistaTerreno;
	}

}
