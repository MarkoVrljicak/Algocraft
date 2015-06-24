package visual.dibujadores;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import modelo.construcciones.Construccion;
import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.propiedad.Propiedad;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;

@SuppressWarnings("rawtypes")
public class DibujadorPropiedades {
	
private static DibujadorPropiedades instance = null;
	
	public static DibujadorPropiedades getInstance(){
		if(instance == null)
			instance = new DibujadorPropiedades();
		
		return instance;
	}
	
	private HashMap<Enum,Dibujador> dibujadores;
	
	protected DibujadorPropiedades(){
		dibujadores = new HashMap<Enum, Dibujador>();
		
		dibujadores.put(EnumEdificiosTerran.BARRACA, new DibujadorBarraca());
		dibujadores.put(EnumEdificiosTerran.BASE_TERRAN, new DibujadorBaseTerran());
		dibujadores.put(EnumEdificiosTerran.CENTRO_DE_MINERALES, new DibujadorCentroDeMineral());
		dibujadores.put(EnumEdificiosTerran.REFINERIA, new DibujadorRefineria());
		dibujadores.put(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, new DibujadorDepositoSuministros());
		
	}

	public JLabel dibujar(Propiedad aDibujar) {
		JLabel imagenObtenida;
		Border border = null;
		if(aDibujar == null){
			imagenObtenida = new DibujadorVacio().dibujar();
		}else if (aDibujar.getColor()==Colores.AZUL)
			border = BorderFactory.createLineBorder(Color.BLUE, 1);
		else
			border = BorderFactory.createLineBorder(Color.RED, 1);
		
		if(aDibujar instanceof Construccion){
			Construccion edificio = (Construccion) aDibujar;
			EnumEdificios nombre = edificio.getNombre();
			imagenObtenida = dibujadores.get(nombre).dibujar();
			imagenObtenida.setBorder(border);
		}else if(aDibujar instanceof Unidad){
			Unidad unidad = (Unidad) aDibujar;
			Unidades nombe = unidad.getNombre();
			imagenObtenida = dibujadores.get(nombe).dibujar();
			imagenObtenida.setBorder(border);
		}else
			imagenObtenida = new DibujadorVacio().dibujar();
		
		return imagenObtenida;
	}

}
