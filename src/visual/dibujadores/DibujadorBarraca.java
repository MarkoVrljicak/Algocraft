package visual.dibujadores;


public class DibujadorBarraca extends Dibujador {

	public DibujadorBarraca(){
		String file;
		file = (pathTexturas + "barraca.png") ;
		imagen = createImageIcon(file,"");
	}
}
