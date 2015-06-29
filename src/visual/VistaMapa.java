package visual;

import java.awt.GridLayout;

import javax.swing.JPanel;

import modelo.Juego;
import modelo.exception.FueraDeLimitesException;
import modelo.mapa.Coordenada;



@SuppressWarnings("serial")
public class VistaMapa extends JPanel {


	public VistaMapa(Juego juego){
		super();
		
		int ancho = juego.getAncho();
		int alto = juego.getAlto();
		
		setLayout(null);
		int anchoCelda = VistaCasillero.anchoCelda;
		int altoCelda = VistaCasillero.altoCelda;
		this.setBounds(0, 0, ancho*anchoCelda, alto*altoCelda);
		this.setLayout(new GridLayout(ancho,alto));
		
		for(int x = 1 ; x <=ancho ; x++){
			for(int y = 1 ; y <= alto ; y++){
				try {
					this.add(new VistaCasillero(new Coordenada(x,y),juego));
				} catch (FueraDeLimitesException e) {
					(new VentanaErrorFatal("Error al crear el mapa")).setVisible(true);
				}
			}
		}
	}
}
