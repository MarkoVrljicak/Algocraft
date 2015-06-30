package visual.vistas;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import modelo.Juego;
import modelo.exception.FueraDeLimitesException;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import visual.VentanaErrorFatal;
import visual.dibujadores.DibujadorPropiedades;

public class VistaCasillero extends JLayeredPane implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635527590416447581L;
	
	
	private Coordenada posicion;
	private Juego observado;
	public static final int anchoCelda = 100;
	public static final int altoCelda = 100;
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.removeAll();
		
		try {
			this.dibujar();
		} catch (FueraDeLimitesException e) {
			(new VentanaErrorFatal("Error al actualizar el mapa")).setVisible(true);
		}
	}
	
	public VistaCasillero(Coordenada coordenada, Juego juego) 
			throws FueraDeLimitesException {
		super();
		setPreferredSize(new Dimension(anchoCelda, altoCelda));
		setLayout(null);
				
		this.posicion = coordenada;
		this.observado = juego;
		this.observado.addObserver(this);

	}
	
	public Coordenada getPosicion(){
		return posicion;
	}

	private void dibujar() throws FueraDeLimitesException {
		Terreno unTerreno = observado.obtenerTerreno(posicion);
		this.dibujarTerreno(unTerreno);
		this.dibujarSuelo(unTerreno);
		this.dibujarCielo(unTerreno);
	}
	
	private void dibujarTerreno(Terreno unTerreno){ 
		RepresentadorDeMapa dibujador = RepresentadorDeMapa.getInstance();
		
		JLabel terrenoADibujar = dibujador.dibujar(unTerreno);
		terrenoADibujar.setVisible(true);
		terrenoADibujar.setBounds(0, 0, anchoCelda, altoCelda);

		add(terrenoADibujar);
	}

	private void dibujarSuelo(Terreno unTerreno) {
		DibujadorPropiedades dibujador = DibujadorPropiedades.getInstance();
		
		JLabel terrenoADibujar =dibujador.dibujar(unTerreno.getContenidoSuelo(),unTerreno.getCoordenada());
		terrenoADibujar.setVisible(true);
		setLayer(terrenoADibujar,1);
		terrenoADibujar.setBounds(0, altoCelda/2, anchoCelda/2, altoCelda/2);

		
		add(terrenoADibujar,10);
	}

	private void dibujarCielo(Terreno unTerreno) {
		DibujadorPropiedades dibujador = DibujadorPropiedades.getInstance();
		
		JLabel terrenoADibujar =dibujador.dibujar(unTerreno.getContenidoCielo(),unTerreno.getCoordenada());
		terrenoADibujar.setVisible(true);
		setLayer(terrenoADibujar,1 );
		terrenoADibujar.setBounds(anchoCelda/2, 0, anchoCelda/2, altoCelda/2);

		add(terrenoADibujar,10);
	}
}
