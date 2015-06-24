package visual.dibujadores;


public class DibujadorAcceso extends Dibujador{

	public DibujadorAcceso(){
		String file;
		file = (pathTexturas + "accesso.png") ;
		imagen = createImageIcon(file,"");
	}

}
