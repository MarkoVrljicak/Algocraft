package visual.dibujadores;


public class DibujadorGolliat extends Dibujador{

	public DibujadorGolliat(){
		String file;
		file = (pathTexturas + "golliat.png") ;
		imagen = createImageIcon(file,"");
	}

}
