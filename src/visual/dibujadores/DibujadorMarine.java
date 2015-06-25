package visual.dibujadores;


public class DibujadorMarine extends Dibujador {

	public DibujadorMarine(){
		String file;
		file = (pathTexturas + "marine.png") ;
		imagen = createImageIcon(file,"");
	}

}
