package visual.dibujadores;


public class DibujadorBaseProtoss extends Dibujador {

	public DibujadorBaseProtoss(){
		String file;
		file = (pathTexturas + "base_protoss.png") ;
		imagen = createImageIcon(file,"");
	}

}
