package visual.dibujadores;

import java.util.HashSet;

import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;

public class DibujadorTerrenoMinerales extends DibujadorTerreno{

	public DibujadorTerrenoMinerales(){
		String file;
		file = (pathTexturas + "cristales.png") ;
		imagen = createImageIcon(file,"");
		this.edificiosConstruibles = new HashSet<EnumEdificios>();
		this.edificiosConstruibles.add(EnumEdificiosProtos.NEXO_MINERAL);
		this.edificiosConstruibles.add(EnumEdificiosTerran.CENTRO_DE_MINERALES);
	}	

}
