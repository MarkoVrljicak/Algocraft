package visual.dibujadores;

import java.util.HashSet;

import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;

public class DibujadorTerrenoTierra extends DibujadorTerreno {
	
	public DibujadorTerrenoTierra(){
		String file;
		file = (pathTexturas + "tierra.png") ;
		imagen = createImageIcon(file,"");
		this.edificiosConstruibles = new HashSet<EnumEdificios>();
		this.edificiosConstruibles.add(EnumEdificiosProtos.ACCESO);
		this.edificiosConstruibles.add(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS);
		this.edificiosConstruibles.add(EnumEdificiosProtos.PILON);
		this.edificiosConstruibles.add(EnumEdificiosProtos.PUERTO_ESTELAR);
		this.edificiosConstruibles.add(EnumEdificiosTerran.BARRACA);
		this.edificiosConstruibles.add(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS);
		this.edificiosConstruibles.add(EnumEdificiosTerran.FABRICA);
		this.edificiosConstruibles.add(EnumEdificiosTerran.PUERTO_ESTELAR);
	}	

}
