package visual.dibujadores;


public class DibujadorScout extends Dibujador {
	public DibujadorScout(){
		String file;
		file = (pathTexturas + "scout.png") ;
		imagen = createImageIcon(file,"");
	}

}
