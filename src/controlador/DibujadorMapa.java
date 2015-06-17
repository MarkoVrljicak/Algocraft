package controlador;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
	
	private BufferedImage imagenTierra;
	private BufferedImage imagenAire;
	private BufferedImage imagenMineral;
	private BufferedImage imagenVolcan;
	
	private static final String texturas ="C://Users//Nicolas//workspace//TpFinal//trunk//src//controlador//texturas//";
	

	public DibujadorMapa(VistaMapa vistaMapa, Juego juego){
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		
		File file;
		try {
			file = new File(texturas + "tierra.png") ;
			imagenTierra =ImageIO.read(file);
			file = new File(texturas + "aire.png") ;
			imagenAire=ImageIO.read(file);
			file = new File(texturas + "cristales.png") ;
			imagenMineral=ImageIO.read(file);
			file = new File(texturas + "volcan.png") ;
			imagenVolcan=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		BufferedImage imagen;
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
		return new JLabel(new ImageIcon( imagen));
    }
}
