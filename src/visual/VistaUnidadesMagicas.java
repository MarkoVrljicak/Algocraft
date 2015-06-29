package visual;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import modelo.unidades.UnidadMagica;

@SuppressWarnings("serial")
public class VistaUnidadesMagicas extends VistaUnidades {

//	private UnidadMagica unidadMagica;

	public VistaUnidadesMagicas(UnidadMagica unidad, ImageIcon imagen) {
		super(unidad, imagen);
//		unidadMagica = unidad;
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		super.mostrarInformacion(barraInformacion);
		//TODO mostrar magia restante y actual
	}
	
	//TODO mostrar magias y triarlas
}
