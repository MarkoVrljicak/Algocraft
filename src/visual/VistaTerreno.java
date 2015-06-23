package visual;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import modelo.Juego;
import modelo.exception.FueraDeLimitesException;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Aire;
import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Tierra;
import visual.dibujadores.DibujadorPropiedades;
import visual.dibujadores.DibujadorTerreno;
import controlador.ControladorMouseCielo;
import controlador.ControladorMouseSuelo;

public class VistaTerreno extends JLayeredPane implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635527590416447581L;
	
	
	private Coordenada posicion;
	private Juego observado;
	private static final int anchoCelda = 30;
	private static final int altoCelda = 30;
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.removeAll();
		
		try {
			this.dibujar();
		} catch (FueraDeLimitesException e) {
			// no ocurre, una vez creado tiene una posicion valida.
			// TODO Avisar por vista
		}
	}
	
	public VistaTerreno(Coordenada coordenada, Juego juego) 
			throws FueraDeLimitesException {
		super();
		setPreferredSize(new Dimension(anchoCelda, altoCelda));
		setLayout(null);
				
		this.posicion = coordenada;
		this.observado = juego;
		this.observado.addObserver(this);

	}

	private void dibujar() throws FueraDeLimitesException {
		Terreno unTerreno = observado.obtenerTerreno(posicion);
		this.dibujarTerreno(unTerreno);
		this.dibujarSuelo(unTerreno);
		this.dibujarCielo(unTerreno);
	}
	
	private void dibujarTerreno(Terreno unTerreno){ 
		DibujadorTerreno dibujador = new DibujadorTerreno();
		
		JLabel terrenoADibujar =dibujador.dibujar(unTerreno);
		terrenoADibujar.setVisible(true);
		terrenoADibujar.setBounds(0, 0, anchoCelda, altoCelda);

		add(terrenoADibujar);
	}

	private void dibujarSuelo(Terreno unTerreno) {
		DibujadorPropiedades dibujador = new DibujadorPropiedades();
		
		JLabel terrenoADibujar =dibujador.dibujar(unTerreno.getContenidoSuelo());
		terrenoADibujar.setVisible(true);
		setLayer(terrenoADibujar,1);
		terrenoADibujar.setBounds(0, 15, 15, 15);
		terrenoADibujar.addMouseListener(new ControladorMouseSuelo(observado, this));

		add(terrenoADibujar,10);
	}

	private void dibujarCielo(Terreno unTerreno) {
		DibujadorPropiedades dibujador = new DibujadorPropiedades();
		
		JLabel terrenoADibujar =dibujador.dibujar(unTerreno.getContenidoCielo());
		terrenoADibujar.setVisible(true);
		setLayer(terrenoADibujar,1 );
		terrenoADibujar.setBounds(15, 0, 15, 15);
		terrenoADibujar.addMouseListener(new ControladorMouseCielo(observado, this));

		add(terrenoADibujar,10);
	}
	//*******************************************tests**********************************************
	public void accionDePruebaSuelo(){
		//accion de prueba para saber si el mouse funciona
		//borra los pedacitos de terreno
		
		this.removeAll();
		this.dibujarTerreno(new Tierra(posicion));
	}
	
	public void accionDePruebaCielo(){
		//accion de prueba para saber si el mouse funciona
		//borra los pedacitos de terreno
		
		this.removeAll();
		this.dibujarTerreno(new Aire(posicion));
	}
	
	
	
}
