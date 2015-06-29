package visual.dibujadores;

import java.util.HashSet;

import modelo.construcciones.EnumEdificios;

public class DibujadorTerrenoAire extends DibujadorTerreno{
	
	public DibujadorTerrenoAire(){
		String file;
		file = (pathTexturas + "aire.png") ;
		imagen = createImageIcon(file,"");
		this.edificiosConstruibles = new HashSet<EnumEdificios>();
	}

}
