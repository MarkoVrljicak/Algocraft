package visual.dibujadores;

import java.util.HashSet;

import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;

public class DibujadorTerrenoVolcan extends DibujadorTerreno{
	
	public DibujadorTerrenoVolcan(){
		String file;
		file = (pathTexturas + "volcan.png") ;
		imagen = createImageIcon(file,"");
		this.edificiosConstruibles = new HashSet<EnumEdificios>();
		this.edificiosConstruibles.add(EnumEdificiosProtos.ASIMILADOR);
		this.edificiosConstruibles.add(EnumEdificiosTerran.REFINERIA);
	}
}
