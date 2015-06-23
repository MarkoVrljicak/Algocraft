package visual.dibujadores;


public class DibujadorAire extends Dibujador {

	public DibujadorAire(){
		String file;
		file =(pathTexturas + "aire.png") ;
		imagen =createImageIcon(file,"aire");
		

	}
}