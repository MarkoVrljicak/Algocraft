package visual.dibujadores;


public class DibujadorNexoMineral extends Dibujador {
	public DibujadorNexoMineral(){
		String file;
		file = (pathTexturas + "nexo_mineral.png") ;
		imagen = createImageIcon(file,"");
	}

}
