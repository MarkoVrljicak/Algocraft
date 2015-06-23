package visual.dibujadores;


public class DibujadorMarine extends Dibujador {

	public DibujadorMarine(){
		String file;
		file = (pathTexturas + "refineria.png") ;
		imagen = createImageIcon(file,"");
	}

}
