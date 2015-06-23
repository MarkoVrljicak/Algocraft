package visual.dibujadores;

import java.util.HashMap;

import javax.swing.JLabel;

import modelo.construcciones.Construccion;
import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.propiedad.Propiedad;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;

@SuppressWarnings("rawtypes")
public class DibujadorPropiedades {
	
	private HashMap<Enum,Dibujador> dibujadores;
	
	public DibujadorPropiedades(){
		dibujadores = new HashMap<Enum, Dibujador>();
		
		dibujadores.put(EnumEdificiosTerran.BARRACA, new DibujadorBarraca());
		dibujadores.put(EnumEdificiosTerran.BASE_TERRAN, new DibujadorBasaTerran());
		dibujadores.put(EnumEdificiosTerran.CENTRO_DE_MINERALES, new DibujadorCentroMinerales());
		dibujadores.put(EnumEdificiosTerran.REFINERIA, new DibujadorRefineria());
		dibujadores.put(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, new DibujadorDepositoSuministros());
		
	}

	public JLabel dibujar(Propiedad aDibujar) {
		if(aDibujar instanceof Construccion){
			Construccion edificio = (Construccion) aDibujar;
			EnumEdificios nombre = edificio.getNombre();
			return dibujadores.get(nombre).dibujar();
		}else if(aDibujar instanceof Unidad){
			Unidad unidad = (Unidad) aDibujar;
			Unidades nombe = unidad.getNombre();
			return dibujadores.get(nombe).dibujar();
		}else
			return new DibujadorVacio().dibujar();
	}

}
