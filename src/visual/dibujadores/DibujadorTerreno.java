package visual.dibujadores;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;
import visual.VistaTerreno;


public class DibujadorTerreno {
	
	private static final String pathTexturas = "texturas/";
	private static DibujadorTerreno instance = null;
	
	public static DibujadorTerreno getInstance(){
		if(instance == null)
			instance = new DibujadorTerreno();
		
		return instance;
	}
	
	private HashMap<Terrenos, ImageIcon> imagenes;
	
	protected DibujadorTerreno(){
		
		imagenes = new HashMap<Terrenos ,ImageIcon>();
		//terrenos
		imagenes.put(Terrenos.TIERRA,createImageIcon(pathTexturas + "tierra.png"));
		imagenes.put(Terrenos.AIRE,createImageIcon(pathTexturas + "aire.png"));
		imagenes.put(Terrenos.MINERALES,createImageIcon(pathTexturas + "cristales.png"));
		imagenes.put(Terrenos.VOLCAN,createImageIcon(pathTexturas + "volcan.png"));		
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public JLabel dibujar(Terreno unTerreno){
		return new VistaTerreno(unTerreno,imagenes.get(unTerreno.getNombre()));
	}

}
