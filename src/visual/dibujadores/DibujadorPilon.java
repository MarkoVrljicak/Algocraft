package visual.dibujadores;


public class DibujadorPilon extends Dibujador {
	public DibujadorPilon(){
		String file;
		file = (pathTexturas + "pilon.png") ;
		imagen = createImageIcon(file,"");
	}

}
