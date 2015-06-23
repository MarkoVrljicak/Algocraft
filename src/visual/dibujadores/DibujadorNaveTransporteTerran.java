package visual.dibujadores;


public class DibujadorNaveTransporteTerran extends Dibujador{
	public DibujadorNaveTransporteTerran(){
		String file;
		file = (pathTexturas + "nave_transporte_terran.png") ;
		imagen = createImageIcon(file,"");
	}

}