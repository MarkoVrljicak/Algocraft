package visual.dibujadores;


public class DibujadorArchivosTemplarios extends Dibujador {

	public DibujadorArchivosTemplarios(){
		String file;
		file = (pathTexturas + "archivos_templarios.png") ;
		imagen = createImageIcon(file,"");
	}

}
