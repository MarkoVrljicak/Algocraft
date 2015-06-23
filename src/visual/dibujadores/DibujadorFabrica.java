package visual.dibujadores;


public class DibujadorFabrica extends Dibujador{

	public DibujadorFabrica(){
		String file;
		file = (pathTexturas + "fabrica.png") ;
		imagen = createImageIcon(file,"");
	}

}
