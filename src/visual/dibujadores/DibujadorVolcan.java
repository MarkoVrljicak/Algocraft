package visual.dibujadores;


public class DibujadorVolcan extends Dibujador {


	public DibujadorVolcan(){
		String file;
		
		file = (pathTexturas + "volcan.png") ;
		imagen = createImageIcon(file,"volcan");

	}

}
