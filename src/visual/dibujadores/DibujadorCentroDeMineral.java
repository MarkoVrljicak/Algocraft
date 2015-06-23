package visual.dibujadores;


public class DibujadorCentroDeMineral extends Dibujador {

	public DibujadorCentroDeMineral(){
		String file;
		file = (pathTexturas + "centro_de_mineral.png") ;
		imagen = createImageIcon(file,"");
	}

}
