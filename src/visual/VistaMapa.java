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
		this.setBounds(0, 0, 900, 900);
		this.setLayout(new GridLayout(ancho,alto));
		
		for(int x = 1 ; x <=ancho ; x++){
			for(int y = 1 ; y <= alto ; y++){
				try {
					this.add(new VistaTerreno(new Coordenada(x,y),juego));
				} catch (FueraDeLimitesException e) {
					// no se puede ir fuera de limites por las condiciones del for
					e.printStackTrace();
				}
			}
		}
	}
}
