package visual.dibujadores;


public class DibujadorAltoTemplario extends Dibujador {

	public DibujadorAltoTemplario(){
		String file;
		file = (pathTexturas + "alto_templario.png") ;
		imagen = createImageIcon(file,"");
	}
}
