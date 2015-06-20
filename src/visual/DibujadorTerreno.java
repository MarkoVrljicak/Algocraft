package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import algocraft.mapa.terrenos.Terrenos;
//borrable
public class DibujadorTerreno {

	private ImageIcon imagenTierra;
	private ImageIcon imagenAire;
	private ImageIcon imagenMineral;
	private ImageIcon imagenVolcan;
	
	private static final String pathTexturas ="texturas//";
	
	public DibujadorTerreno(){
		String file;
		file = (pathTexturas + "tierra.png") ;
		imagenTierra =createImageIcon(file,"tierra");
		file =(pathTexturas + "aire.png") ;
		imagenAire=createImageIcon(file,"aire");
		file = (pathTexturas + "cristales.png") ;
		imagenMineral=createImageIcon(file,"mineral");
		file = (pathTexturas + "volcan.png") ;
		imagenVolcan=createImageIcon(file,"volcan");
	}
	
	private ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public JLabel dibujarTerreno(Terrenos nombreTerreno){
		ImageIcon imagen;
		switch(nombreTerreno){
		case AIRE:
			imagen =imagenAire;
			break;
		case MINERALES:
			imagen =imagenMineral;
			break;
		case TIERRA:
			imagen =imagenTierra;
			break;
		case VOLCAN:
			imagen =imagenVolcan;
			break;
		default:
			imagen =imagenTierra;
			break;
		}
		return new JLabel(imagen);
    }
}
