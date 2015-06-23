package visual.dibujadores;


public class DibujadorBaseTerran extends Dibujador {

	public DibujadorBaseTerran(){
		String file;
		file = (pathTexturas + "base_terran.png") ;
		imagen = createImageIcon(file,"");
	}


}
