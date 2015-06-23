package visual.dibujadores;


public class DibujadorPuertoEstelarTerran extends Dibujador {
	public DibujadorPuertoEstelarTerran(){
		String file;
		file = (pathTexturas + "puerto_estelar_terran.png") ;
		imagen = createImageIcon(file,"");
	}
}
