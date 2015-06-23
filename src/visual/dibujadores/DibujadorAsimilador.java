package visual.dibujadores;


public class DibujadorAsimilador extends Dibujador {
	public DibujadorAsimilador(){
		String file;
		file = (pathTexturas + "asimilador.png") ;
		imagen = createImageIcon(file,"");
	}

}
