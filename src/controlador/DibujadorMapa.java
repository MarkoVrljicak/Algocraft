package controlador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import visual.VistaMapa;
import algocraft.Juego;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;

public class DibujadorMapa {

	private VistaMapa vistaMapa;
	private Juego juego;
	
	private ImageIcon imagenTierra;
	private ImageIcon imagenAire;
	private ImageIcon imagenMineral;
	private ImageIcon imagenVolcan;
	
	private static final String pathTexturas ="texturas//";
	

	public DibujadorMapa(VistaMapa vistaMapa, Juego juego){
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		
		String file;
		file = (pathTexturas + "tierra.png") ;
		imagenTierra =createImageIcon(file,"");
		file =(pathTexturas + "aire.png") ;
		imagenAire=createImageIcon(file,"");
		file = (pathTexturas + "cristales.png") ;
		imagenMineral=createImageIcon(file,"");
		file = (pathTexturas + "volcan.png") ;
		imagenVolcan=createImageIcon(file,"");
	}
	
	protected ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public void dibujar(){
		final int anchoCelda = 30;
		final int altoCelda = 30;
		Mapa mapa = juego.mapa;
		for(int x = 1 ; x <=mapa.getAncho() ; x++){
			for(int y = 1 ; y <= mapa.getAlto() ; y++){
				try {
					Terreno unTerreno = juego.obtenerTerreno(new Coordenada(x,y));
					JLabel terrenoADibujar = this.dibujarTerreno(unTerreno.getNombre());
					terrenoADibujar.setBounds((x-1)*anchoCelda,(y-1)*altoCelda,anchoCelda,altoCelda);
					terrenoADibujar.setVisible(true);
					vistaMapa.add(terrenoADibujar);
				} catch (FueraDeLimitesException e) {
					// los for lo evitan
					e.printStackTrace();
				}				
			}
		}
		JLabel terrenoADibujar = this.dibujarTerreno(Terrenos.VOLCAN);
		terrenoADibujar.setBounds(0*anchoCelda,0*altoCelda,anchoCelda,altoCelda);
		terrenoADibujar.setVisible(true);
		vistaMapa.add(terrenoADibujar);
	}
	
	private JLabel dibujarTerreno(Terrenos nombreTerreno){
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
