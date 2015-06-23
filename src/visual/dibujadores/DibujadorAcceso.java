package visual.dibujadores;


public class DibujadorAcceso extends Dibujador{

	public DibujadorAcceso(){
		String file;
		file = (pathTexturas + "acceso.png") ;
		imagen = createImageIcon(file,"");
	}

}
