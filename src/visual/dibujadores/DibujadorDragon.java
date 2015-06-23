package visual.dibujadores;


public class DibujadorDragon extends Dibujador{

	public DibujadorDragon(){
		String file;
		file = (pathTexturas + "dragon.png") ;
		imagen = createImageIcon(file,"");
	}

}
