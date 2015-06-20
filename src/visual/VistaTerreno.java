package visual;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import algocraft.Juego;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.terrenos.Aire;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.mapa.terrenos.Tierra;
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
			e.printStackTrace();
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
		
			
		dibujar();
	}

	private void dibujar() throws FueraDeLimitesException {
		Terreno unTerreno = observado.obtenerTerreno(posicion);
		this.dibujarTerreno(unTerreno);
		this.dibujarSuelo(unTerreno);
		this.dibujarCielo(unTerreno);
	}
	
	private void dibujarTerreno(Terreno unTerreno){ 
		DibujadorTerreno dibujador = new DibujadorTerreno();
		
		JLabel terrenoADibujar =dibujador.dibujarTerreno(unTerreno.getNombre());
		terrenoADibujar.setVisible(true);
		terrenoADibujar.setBounds(0, 0, anchoCelda, altoCelda);

		add(terrenoADibujar);
	}

	private void dibujarSuelo(Terreno unTerreno) {
		//cambiar por un dibujador de unidades o afin
		DibujadorTerreno dibujador = new DibujadorTerreno();
		
		JLabel terrenoADibujar =dibujador.dibujarTerreno(Terrenos.TIERRA);
		terrenoADibujar.setVisible(true);
		setLayer(terrenoADibujar,1);
		terrenoADibujar.setBounds(0, 15, 15, 15);
		terrenoADibujar.addMouseListener(new ControladorMouseSuelo(observado, this));

		add(terrenoADibujar,10);
	}

	private void dibujarCielo(Terreno unTerreno) {
		//cambiar por un dibujador de unidades y edificios o afin
		DibujadorTerreno dibujador = new DibujadorTerreno();
		
		JLabel terrenoADibujar =dibujador.dibujarTerreno(Terrenos.AIRE);
		terrenoADibujar.setVisible(true);
		setLayer(terrenoADibujar,1);
		terrenoADibujar.setBounds(15, 0, 15, 15);
		terrenoADibujar.addMouseListener(new ControladorMouseCielo(observado, this));

		add(terrenoADibujar,10);
	}
	
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
